package com.codea.eccomerce.infrastructure.mapper;


import com.codea.eccomerce.domain.OrderProduct;
import com.codea.eccomerce.infrastructure.entity.OderProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ProductMapper.class, OrderMapper.class})
public interface OrderProductMapper {
    @Mappings(
            {
                    @Mapping( source = "pk.productEntity" , target = "product"),
                    @Mapping( source = "quantity" , target = "quantity"),
                    @Mapping( source = "pk.orderEntity" , target = "order"),

            }   
    )

    OrderProduct toOrderProduct(OderProductEntity orderProductEntity);
    Iterable<OrderProduct> toOrderProducts(Iterable<OderProductEntity> orderProductEntities);
    List<OrderProduct> toOrderProductList(Iterable<OderProductEntity> orderProductEntities);

    @InheritInverseConfiguration
    OderProductEntity toOderProductEntity(OrderProduct orderProduct);
}
