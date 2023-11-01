package com.example.demo.vo.web;

import com.example.demo.entity.Order;
import com.example.demo.vo.WebOrderListVO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Page;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrderListResponse extends BaseResponse {

    @Schema(type = "java.lang.Integer",
            description = "總頁數",
            example = "8")
    public int totalPage;

    @Schema(type = "java.lang.Long",
            description = "總數",
            example = "80")
    public long totalCount;

    public List<WebOrderListVO> data;

    public OrderListResponse(Page<Order> pageResult, List<WebOrderListVO> webOrderListVOList) {
        this.statusCode = 200;
        this.message = "success";
        this.totalCount = pageResult.getTotalElements();
        this.totalPage = pageResult.getTotalPages();
        this.data = webOrderListVOList;
    }
}
