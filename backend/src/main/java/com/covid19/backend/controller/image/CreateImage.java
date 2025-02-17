package com.covid19.backend.controller.image;

import com.covid19.backend.controller.BaseController;
import com.covid19.backend.model.Result;
import com.covid19.backend.model.Image;
import com.covid19.backend.service.image.CreateImageService;
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


@RestController
@Api(tags = "肺部影像控制器", value = "和肺部影像有关的控制器")
public class CreateImage extends BaseController{
    @Autowired
    public CreateImageService createImageService;

    @PostMapping("/image/createImage")
    @ApiOperation(value = "创建图像信息", notes = "可以创建图像信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "patient_id",value = "病人ID"),
            @ApiImplicitParam(name = "scanning_doctor_id",value = "扫描医生 ID"),
            @ApiImplicitParam(name = "image_picture",value = "肺部影像图片"),
            @ApiImplicitParam(name = "conclusion",value = "结论"),
            @ApiImplicitParam(name = "conclusion_doctor_id",value = "结论医生"),
    })
    public Result createMedicine(
            @RequestParam(value = "patient_id",required = false)String patient_id,
            @RequestParam(value = "scanning_doctor_id",required = false)String scanning_doctor_id,
            @RequestParam(value = "image_picture",required = false)String image_picture,
            @RequestParam(value = "conclusion",required = false)String conclusion,
            @RequestParam(value = "conclusion_doctor_id",required = false)String conclusion_doctor_id,
            HttpServletRequest request)
    {
        if(createImageService.checkCurrentUserInfo(request) == -1)
            return Result.error(Result.CODE_UNAUTHORIZED, "账号信息错误。");

        Image image = new Image();

        image.setPatient_id(patient_id);
        image.setScanning_doctor_id(scanning_doctor_id);
        image.setImage_picture(image_picture);
        image.setConclusion(conclusion);
        image.setConclusion_doctor_id(conclusion_doctor_id);

        Image new_image = createImageService.createImage(image);
        return Result.ok(new_image);
    }
}
