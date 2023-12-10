package com.college.sportik.feature.product.service;

import com.college.sportik.feature.category.dto.CategoryDTOResponse;
import com.college.sportik.feature.category.entity.CategoryEntity;
import com.college.sportik.feature.category.repository.CategoryRepository;
import com.college.sportik.feature.product.dto.*;
import com.college.sportik.feature.product.entity.ProductEntity;
import com.college.sportik.feature.product.entity.characteristic.CharacteristicEntity;
import com.college.sportik.feature.product.entity.characteristic.SubCharacteristicEntity;
import com.college.sportik.feature.product.entity.dimension.DimensionEntity;
import com.college.sportik.feature.product.entity.dimension.SubDimensionEntity;
import com.college.sportik.feature.product.entity.image.ImageEntity;
import com.college.sportik.feature.product.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ImageRepository imageRepository;
    private final CharacteristicRepository characteristicRepository;
    private final SubCharacteristicRepository subCharacteristicRepository;
    private final DimensionRepository dimensionRepository;
    private final SubDimensionRepository subDimensionRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ImageRepository imageRepository, CharacteristicRepository characteristicRepository, SubCharacteristicRepository subCharacteristicRepository, DimensionRepository dimensionRepository, SubDimensionRepository subDimensionRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
        this.characteristicRepository = characteristicRepository;
        this.subCharacteristicRepository = subCharacteristicRepository;
        this.dimensionRepository = dimensionRepository;
        this.subDimensionRepository = subDimensionRepository;
    }


    @Override
    public ProductDTOResponse createProduct(ProductDTOResponse productDTOResponse) {

        List<ImageDTOResponse> images = productDTOResponse.getImages();
        List<CharacteristicDTOResponse> characteristics = productDTOResponse.getCharacteristics();
        List<DimensionDTOResponse> dimensions = productDTOResponse.getDimensions();
        List<SubCharacteristicDTOResponse> subCharacteristics = new ArrayList<>();
        List<SubDimensionDTOResponse> subDimensions = new ArrayList<>();

        CategoryDTOResponse category = categoryRepository.findByCode(productDTOResponse.getCategory());

        productRepository.save(new ProductEntity(
                productDTOResponse.getId(),
                productDTOResponse.getVendorCode(),
                productDTOResponse.getTitle(),
                productDTOResponse.getDescription(),
                productDTOResponse.getBrand(),
                productDTOResponse.getPrice(),
                productDTOResponse.getColor(),
                productDTOResponse.getDateCreated(),
                new CategoryEntity(
                        category.getId(),
                        category.getTitle(),
                        category.getCode()
                ),
                null,
                null,
                imagesToEntity(productDTOResponse.getImages())
        ));
        Integer product_id = productRepository.findByVendorCode(productDTOResponse.getVendorCode()).getId();

        for (CharacteristicDTOResponse characteristic : characteristics) {
            productRepository.createCharacteristic(characteristic.getId(), characteristic.getTitle(), product_id);
        }


        productDTOResponse.getCharacteristics().forEach(item -> {
                    subCharacteristics.addAll(item.getSubCharacteristic());

                    characteristicRepository.findCharacteristicByProductId(product_id).forEach(characteristic -> {
                        if (item.getTitle().equals(characteristic.getTitle())) {
                            subCharacteristics.forEach(subCharacteristic -> {
                                productRepository.createSubCharacteristic(subCharacteristic.getId(), subCharacteristic.getDescription(), subCharacteristic.getTitle(), characteristic.getId());
                            });
                            subCharacteristics.clear();
                        }
                    });
                }
        );

        System.out.println("TAGTAG  " + productDTOResponse.getDimensions());

        for (DimensionDTOResponse dimension : dimensions) {
            productRepository.createDimension(dimension.getId(), dimension.getTitle(), product_id);
        }

        productDTOResponse.getDimensions().forEach(item -> {
                    subDimensions.addAll(item.getSubDimensions());

                    dimensionRepository.findDimensionByProductId(product_id).forEach(dimension -> {
                        if (item.getTitle().equals(dimension.getTitle())) {
                            subDimensions.forEach(subDimension -> {
                                productRepository.createSubDimension(subDimension.getId(), subDimension.getSize(), dimension.getId());
                            });
                            subDimensions.clear();
                        }
                    });
                }
        );

        for (ImageDTOResponse image : images) {
            productRepository.createImage(image.getId(), image.getTitle(), product_id);
        }

        return productDTOResponse;
    }

    @Override
    public ProductDTOReceive getProductById(Long id) {
        ProductEntity product = productRepository.findProductById(id);
        return new ProductDTOReceive(
                product.getId(),
                product.getTitle(),
                product.getBrand(),
                product.getDescription(),
                product.getColor(),
                product.getPrice(),
                product.getVendorCode(),
                categoryRepository.findByCode(product.getCategory().getCode()),
                product.getDateCreated(),
                characteristicToDTO(product),
                dimensionToDTO(product),
                imagesToDTO(product)
        );
    }

    @Override
    public List<ProductDTOReceive> getProducts() {
        List<ProductDTOReceive> products = new ArrayList<>();
        productRepository.findAll().forEach(item -> {
                    products.add(
                            new ProductDTOReceive(
                                    item.getId(),
                                    item.getTitle(),
                                    item.getBrand(),
                                    item.getDescription(),
                                    item.getColor(),
                                    item.getPrice(),
                                    item.getVendorCode(),
                                    categoryRepository.findByCode(item.getCategory().getCode()),
                                    item.getDateCreated(),
                                    characteristicToDTO(item),
                                    dimensionToDTO(item),
                                    imagesToDTO(item)
                            )
                    );
                }
        );
        return products;
    }

    @Override
    public String deleteProductById(Long id) {
        productRepository.deleteById(id);
        return "Product with id " + id + " deleted";
    }

    private List<ImageEntity> imagesToEntity(List<ImageDTOResponse> images) {
        ArrayList<ImageEntity> imageEntities = new ArrayList<>();
        for (ImageDTOResponse item : images) {
            imageEntities.add(new ImageEntity(
                    item.getId(),
                    null,
                    item.getTitle()
            ));
        }
        return imageEntities;
    }

    private List<ImageDTOResponse> imagesToDTO(ProductEntity product) {
        List<ImageDTOResponse> images = new ArrayList<>();
        imageRepository.findImagesByProductId(product.getId()).forEach(image -> {
            images.add(new ImageDTOResponse(
                    image.getId(),
                    image.getTitle(),
                    image.getProduct().getId()
            ));
        });
        return images;
    }

    private List<CharacteristicDTOResponse> characteristicToDTO(ProductEntity product) {
        List<CharacteristicDTOResponse> characteristics = new ArrayList<>();
        List<CharacteristicEntity> characteristicEntities = characteristicRepository.findCharacteristicByProductId(product.getId());

        for (CharacteristicEntity characteristic : characteristicEntities) {
            List<SubCharacteristicDTOResponse> subCharacteristics = new ArrayList<>();
            List<SubCharacteristicEntity> subCharacteristicEntities = subCharacteristicRepository.findSubCharacteristicByCharacteristicId(characteristic.getId());

            for (SubCharacteristicEntity subCharacteristic : subCharacteristicEntities) {
                if (characteristic.getId().equals(subCharacteristic.getCharacteristic().getId())) {
                    subCharacteristics.add(new SubCharacteristicDTOResponse(
                            subCharacteristic.getId(),
                            subCharacteristic.getTitle(),
                            subCharacteristic.getDescription(),
                            characteristic.getId()
                    ));
                }
            }

            characteristics.add(new CharacteristicDTOResponse(
                    characteristic.getId(),
                    characteristic.getTitle(),
                    characteristic.getProduct().getId(),
                    subCharacteristics
            ));
        }

        return characteristics;
    }

    private List<DimensionDTOResponse> dimensionToDTO(ProductEntity product) {
        List<DimensionDTOResponse> dimensions = new ArrayList<>();
        List<DimensionEntity> dimensionEntities = dimensionRepository.findDimensionByProductId(product.getId());

        for (DimensionEntity dimension : dimensionEntities) {
            List<SubDimensionDTOResponse> subDimensions = new ArrayList<>();
            List<SubDimensionEntity> subDimensionEntities = subDimensionRepository.findSubDimensionByDimensionId(dimension.getId());

            for (SubDimensionEntity subDimension : subDimensionEntities) {
                if (dimension.getId().equals(subDimension.getDimension().getId())) {
                    subDimensions.add(new SubDimensionDTOResponse(
                            subDimension.getId(),
                            subDimension.getSize(),
                            subDimension.getDimension().getId()
                    ));
                }
            }

            dimensions.add(new DimensionDTOResponse(
                    dimension.getId(),
                    dimension.getTitle(),
                    subDimensions,
                    dimension.getProduct().getId()
            ));
        }

        return dimensions;
    }

//    private List<DimensionDTOResponse> dimensionToDTO2(ProductEntity product) {
//        List<SubDimensionDTOResponse> subDimensions = new ArrayList<>();
//        List<DimensionDTOResponse> dimensions = new ArrayList<>();
//        dimensionRepository.findDimensionByProductId(product.getId()).forEach(dimension -> {
//
//            subDimensionRepository.findSubDimensionByDimensionId(dimension.getId()).forEach(subDimension ->
//                    subDimensions.add(new SubDimensionDTOResponse(
//                            subDimension.getId(),
//                            subDimension.getSize(),
//                            subDimension.getDimension().getId()
//                    ))
//            );
//
//            dimensions.add(new DimensionDTOResponse(
//                    dimension.getId(),
//                    dimension.getTitle(),
//                    subDimensions,
//                    dimension.getProduct().getId()
//            ));
//        });
//        return dimensions;
//    }


}
