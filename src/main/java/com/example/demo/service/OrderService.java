package com.example.demo.service;

import com.example.demo.entity.Account;
import com.example.demo.entity.Order;
import com.example.demo.entity.OrderDetail;
import com.example.demo.entity.Product;
import com.example.demo.repository.IOrderDetailRepository;
import com.example.demo.repository.IOrderRepository;
import com.example.demo.util.Constants;
import com.example.demo.vo.OrderDetailVO;
import com.example.demo.vo.QueryOrderListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    IOrderRepository orderRepository;

    @Autowired
    IOrderDetailRepository orderDetailRepository;

    public Order create(Account account, List<OrderDetailVO> orderDetailVOList) {

        LocalDateTime now = LocalDateTime.now();

        Order order = new Order();
        order.setNumber(UUID.randomUUID().toString().replace("-", ""));
        order.setAccountId(account.getId());
        order.setAccountName(account.getName());
        order.setCreateDatetime(now);

        int totalAmount = 0;

        OrderDetail orderDetail;
        for (OrderDetailVO detail : orderDetailVOList) {
            orderDetail = new OrderDetail();
            orderDetail.setOrderId(order.getId());
            orderDetail.setProductId(detail.getProduct().getId());
            orderDetail.setProductName(detail.getProduct().getName());
            orderDetail.setCount(detail.getCount());
            orderDetail.setAmount(detail.getProduct().getPrice() * detail.getCount());
            orderDetail.setCreateDatetime(now);
            totalAmount += orderDetail.getAmount();
            orderDetailRepository.save(orderDetail);
        }

        order.setTotalAmount(totalAmount);

        order = orderRepository.save(order);

        return order;
    }

    public Page<Order> queryList(QueryOrderListVO queryOrderListVO) throws ParseException {

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(Constants.WEB_DATE_FORMAT);
        Pageable pageable = PageRequest.of(queryOrderListVO.getPage() - 1, queryOrderListVO.getSize());

        Page<Order> orderPage = orderRepository.findOrderPageByCondition(
                queryOrderListVO.getOrderNumber(),
                simpleDateFormat.parse(queryOrderListVO.getStartDatetime()),
                simpleDateFormat.parse(queryOrderListVO.getEndDatetime()),
                pageable);

        return orderPage;
    }
}
