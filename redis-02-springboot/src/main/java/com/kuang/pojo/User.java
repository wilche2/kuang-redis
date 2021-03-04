package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author caoweiquan
 * @date 2021/3/3
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private String name;

}
