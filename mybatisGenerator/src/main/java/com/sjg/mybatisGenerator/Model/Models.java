package com.sjg.mybatisGenerator.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* Created by Mybatis Generator on 2019/07/05
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Models {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column models.model_id
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    private Integer modelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column models.model_name
     *
     * @mbg.generated Fri Jul 05 11:29:17 CST 2019
     */
    private String modelName;
}