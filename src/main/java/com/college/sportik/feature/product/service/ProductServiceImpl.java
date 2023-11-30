package com.college.sportik.feature.product.service;

import com.college.sportik.feature.category.dto.CategoryDTOResponse;
import com.college.sportik.feature.category.entity.CategoryEntity;
import com.college.sportik.feature.category.repository.CategoryRepository;
import com.college.sportik.feature.product.dto.*;
import com.college.sportik.feature.product.entity.ProductEntity;
import com.college.sportik.feature.product.entity.characteristic.CharacteristicEntity;
import com.college.sportik.feature.product.entity.characteristic.SubCharacteristicEntity;
import com.college.sportik.feature.product.entity.image.ImageEntity;
import com.college.sportik.feature.product.repository.CharacteristicRepository;
import com.college.sportik.feature.product.repository.ImageRepository;
import com.college.sportik.feature.product.repository.ProductRepository;
import com.college.sportik.feature.product.repository.SubCharacteristicRepository;
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

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, ImageRepository imageRepository, CharacteristicRepository characteristicRepository, SubCharacteristicRepository subCharacteristicRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.imageRepository = imageRepository;
        this.characteristicRepository = characteristicRepository;
        this.subCharacteristicRepository = subCharacteristicRepository;
    }

    @Override
    public ProductDTOResponse createProduct(ProductDTOResponse productDTOResponse) {

        List<ImageDTOResponse> images = productDTOResponse.getImages();
        List<CharacteristicDTOResponse> characteristics = productDTOResponse.getCharacteristics();
        List<SubCharacteristicDTOResponse> subCharacteristics = new ArrayList<>();

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
                    System.out.println("TAGTAG   " + subCharacteristics);

                    characteristicRepository.findCharacteristicByProductId(product_id).forEach(characteristic -> {

                        subCharacteristics.forEach(subCharacteristic -> {
                            productRepository.createSubCharacteristic(subCharacteristic.getId(), subCharacteristic.getDescription(), subCharacteristic.getTitle(), characteristic.getId());
                        });
                        subCharacteristics.clear();
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
//        ProductDTOReceive product = productRepository.findById(id).map(item ->
//
//            List<ImageDTOResponse> images = new ArrayList<>();
//            imageRepository.findImagesByProductId(item.getId()).forEach(image -> {
//                images.add(new ImageDTOResponse(
//                        image.getId(),
//                        image.getTitle(),
//                        image.getProduct().getId()
//                ));
//            });
//            List<SubCharacteristicDTOResponse> subCharacteristics = new ArrayList<>();
//
//            List<CharacteristicDTOResponse> characteristics = new ArrayList<>();
//            characteristicRepository.findCharacteristicByProductId(item.getId()).forEach(characteristic -> {
//
//                subCharacteristicRepository.findSubCharacteristicByCharacteristicId(characteristic.getId()).forEach(subCharacteristic ->
//                        subCharacteristics.add(new SubCharacteristicDTOResponse(
//                                subCharacteristic.getId(),
//                                subCharacteristic.getTitle(),
//                                subCharacteristic.getDescription(),
//                                characteristic.getId()
//                        ))
//                );
//
//                characteristics.add(new CharacteristicDTOResponse(
//                        characteristic.getId(),
//                        characteristic.getTitle(),
//                        characteristic.getProduct().getId(),
//                        subCharacteristics
//                ));
//            });
//
//            new ProductDTOReceive(
//                    item.getId(),
//                    item.getTitle(),
//                    item.getBrand(),
//                    item.getDescription(),
//                    item.getColor(),
//                    item.getPrice(),
//                    item.getVendorCode(),
//                    categoryRepository.findByCode(item.getCategory().getCode()),
//                    item.getDateCreated(),
//                    null,
//                    null,
//                    null
//            );
//            return
//        );
        return null;
    }

    @Override
    public List<ProductDTOReceive> getProducts() {
        List<ProductDTOReceive> products = new ArrayList<>();
        productRepository.findAll().forEach(item -> {
                    List<ImageDTOResponse> images = new ArrayList<>();
                    imageRepository.findImagesByProductId(item.getId()).forEach(image -> {
                        images.add(new ImageDTOResponse(
                                image.getId(),
                                image.getTitle(),
                                image.getProduct().getId()
                        ));
                    });
                    List<SubCharacteristicDTOResponse> subCharacteristics = new ArrayList<>();

                    List<CharacteristicDTOResponse> characteristics = new ArrayList<>();
                    characteristicRepository.findCharacteristicByProductId(item.getId()).forEach(characteristic -> {

                        subCharacteristicRepository.findSubCharacteristicByCharacteristicId(characteristic.getId()).forEach(subCharacteristic ->
                                subCharacteristics.add(new SubCharacteristicDTOResponse(
                                        subCharacteristic.getId(),
                                        subCharacteristic.getTitle(),
                                        subCharacteristic.getDescription(),
                                        characteristic.getId()
                                ))
                        );

                        characteristics.add(new CharacteristicDTOResponse(
                                characteristic.getId(),
                                characteristic.getTitle(),
                                characteristic.getProduct().getId(),
                                subCharacteristics
                        ));
                    });
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
                                    characteristics,
                                    null,
                                    images
                            )
                    );
                }
        );
        return products;
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

    private List<CharacteristicEntity> characteristicToEntity(List<CharacteristicDTOResponse> characteristics) {
        ArrayList<CharacteristicEntity> characteristicEntities = new ArrayList<>();
        for (CharacteristicDTOResponse item : characteristics) {
            characteristicEntities.add(new CharacteristicEntity(
                    item.getId(),
                    null,
                    item.getTitle(),
                    subCharacteristicToEntity(item.getSubCharacteristic())
            ));
        }
        return characteristicEntities;
    }

    private List<SubCharacteristicEntity> subCharacteristicToEntity(List<SubCharacteristicDTOResponse> subCharacteristics) {
        ArrayList<SubCharacteristicEntity> subCharacteristicEntities = new ArrayList<>();
        for (SubCharacteristicDTOResponse item : subCharacteristics) {
            subCharacteristicEntities.add(new SubCharacteristicEntity(
                    item.getId(),
                    null,
                    item.getTitle(),
                    item.getDescription()
            ));
        }
        return subCharacteristicEntities;
    }
}
