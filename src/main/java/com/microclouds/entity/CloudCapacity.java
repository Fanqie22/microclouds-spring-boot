package com.microclouds.entity;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author https://github.com/Fanqie22
 * @since 2019-01-17
 */
@TableName("cloud_capacity")
public class CloudCapacity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     *
     */
    private BigDecimal occupied;

    /**
     *
     */
    @TableField(value = "all_capacity")
    private BigDecimal allCapacity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public BigDecimal getOccupied() {
        return occupied;
    }

    public void setOccupied(BigDecimal occupied) {
        this.occupied = occupied;
    }

    public BigDecimal getAllCapacity() {
        return allCapacity;
    }

    public void setAllCapacity(BigDecimal allCapacity) {
        this.allCapacity = allCapacity;
    }

}
