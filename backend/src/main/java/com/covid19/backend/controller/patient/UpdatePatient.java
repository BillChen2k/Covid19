package com.covid19.backend.controller.patient;

import com.covid19.backend.controller.BaseController;
import com.covid19.backend.model.Result;
import com.covid19.backend.model.Patient;
import com.covid19.backend.service.patient.GetPatientInfoService;
import com.covid19.backend.service.patient.UpdatePatientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
/**
 * 更新病人控制器
 */
@RestController
@Api(tags = "病人控制器", value = "和病人有关的控制器")
public class UpdatePatient extends BaseController{
    @Autowired
    public UpdatePatientService updatePatientService;
    @Autowired
    public GetPatientInfoService getPatientInfoService;

    @PostMapping("/patient/updatePatient")
    @ApiOperation(value = "更新病人信息", notes = "可以更新病人信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "patient_id",value = "病人ID"),
            @ApiImplicitParam(name = "patient_name",value = "病人名称"),
            @ApiImplicitParam(name = "patient_gender",value = "病人性别"),
            @ApiImplicitParam(name = "patient_birthday",value = "病人生日"),
            @ApiImplicitParam(name = "onset_place",value = "发病地点"),
            @ApiImplicitParam(name = "onset_date",value = "发病时间"),
            @ApiImplicitParam(name = "confirm_date",value = "确诊时间"),
            @ApiImplicitParam(name = "status",value = "住院状态"),
            @ApiImplicitParam(name = "doctor_id",value = "主治大夫"),
            @ApiImplicitParam(name = "hospital_id",value = "治疗医院"),
            @ApiImplicitParam(name = "is_doctor",value = "是否是医生")
    })
    public Result updatePatient(
            @RequestParam(value = "patient_id") long patient_id,
            @RequestParam(value = "patient_name", required = false) String patient_name,
            @RequestParam(value = "patient_gender",required = false)String patient_gender,
            @RequestParam(value = "patient_birthday",required = false)String patient_birthday,
            @RequestParam(value = "onset_place",required = false)String onset_place,
            @RequestParam(value = "onset_date",required = false)String onset_date,
            @RequestParam(value = "confirm_date",required = false)String confirm_date,
            @RequestParam(value = "status",required = false)String status,
            @RequestParam(value = "doctor_id",required = false)String doctor_id,
            @RequestParam(value = "hospital_id",required = false)String hospital_id,
            @RequestParam(value = "is_doctor",required = false)String is_doctor,
            HttpServletRequest request)
    {
        if(updatePatientService.checkCurrentUserInfo(request) == -1)
            return Result.error(Result.CODE_UNAUTHORIZED, "账号信息错误。");
        Patient patient = getPatientInfoService.getPatientInfoByID(patient_id);
        if(patient == null) return Result.error(2012,"不存在该病人");

        Patient new_patient = updatePatientService.updatePatient(
                patient_id,
                patient_name,
                patient_gender,
                patient_birthday,
                onset_place,
                onset_date,
                confirm_date,
                status,
                doctor_id,
                hospital_id,
                is_doctor);
        return Result.ok(new_patient);
    }
}
