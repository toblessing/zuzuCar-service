package com.sjg.zuzuCar.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
* Created by Mybatis Generator on 2019/07/06
*/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationForm {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reservation_form.reservation_form_id
     *
     * @mbg.generated Sat Jul 06 01:22:22 CST 2019
     */
    private Integer reservationFormId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reservation_form.holder_id
     *
     * @mbg.generated Sat Jul 06 01:22:22 CST 2019
     */
    private Integer holderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reservation_form.reservation_id
     *
     * @mbg.generated Sat Jul 06 01:22:22 CST 2019
     */
    private Integer reservationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reservation_form.license_plate
     *
     * @mbg.generated Sat Jul 06 01:22:22 CST 2019
     */
    private String licensePlate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reservation_form.model_id
     *
     * @mbg.generated Sat Jul 06 01:22:22 CST 2019
     */
    private Integer modelId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reservation_form.free_start_time
     *
     * @mbg.generated Sat Jul 06 01:22:22 CST 2019
     */
    private Long freeStartTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reservation_form.free_end_time
     *
     * @mbg.generated Sat Jul 06 01:22:22 CST 2019
     */
    private Long freeEndTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column reservation_form.reservation_time
     *
     * @mbg.generated Sat Jul 06 01:22:22 CST 2019
     */
    private Long reservationTime;
}