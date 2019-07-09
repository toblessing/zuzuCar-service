package com.sjg.zuzuCar.Model.custom;

import com.sjg.zuzuCar.Model.ReservationForm;
import lombok.*;

/**
 * @ClassName ReservationFormCustom
 * @Author ble
 * @Date 2019/7/9 9:34
 * 功能:
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ReservationFormCustom extends ReservationForm {
    private String userName;
    private String netName;
    private String phone;
    private String modelName;
}
