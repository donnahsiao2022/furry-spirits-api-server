package com.example.demo.vo.util;

import com.example.demo.entity.Order;
import com.example.demo.enums.OrderStatus;
import com.example.demo.vo.web.WebOrderListVO;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface VOMapper {

    default List<WebOrderListVO> toWebOrderListVO(List<Order> orderList) {

        List<WebOrderListVO> webOrderListVOList = new ArrayList<>();

        WebOrderListVO webOrderListVO;

        for (Order order : orderList) {

            webOrderListVO = new WebOrderListVO();

            webOrderListVO.setId(order.getId());
            webOrderListVO.setOrderNumber(order.getNumber());
            webOrderListVO.setBuyerId(order.getAccountId());
            webOrderListVO.setBuyerName(order.getAccountName());
            webOrderListVO.setStatus(order.getStatus());
            webOrderListVO.setStatusDescription(OrderStatus.fromOrdinal(order.getStatus()).getMessage());
            webOrderListVO.setTotalAmount(order.getTotalAmount());
            webOrderListVO.setCreateDatetime(order.getCreateDatetime());
            webOrderListVO.setPayDatetime(order.getPayDatetime());

            webOrderListVOList.add(webOrderListVO);
        }

        return webOrderListVOList;
    }

}
