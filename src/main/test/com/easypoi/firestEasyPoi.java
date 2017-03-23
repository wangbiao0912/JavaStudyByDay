package com.easypoi;

import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.junit.Test;
import org.springframework.ui.ModelMap;

/**
 * Created by pc5 on 2017/3/23.
 * 导出表格工具
 */
public class firestEasyPoi {
    @Test
    public void downlaodPoi()
    {
        System.out.print("11111111");
        List<CourseEntity> courses = this.courseService.getListByCriteriaQuery(cq,false);
        map.put(NormalExcelConstants.FILE_NAME,"用户信息");
        map.put(NormalExcelConstants.CLASS,CourseEntity.class);
        map.put(NormalExcelConstants.PARAMS,new ExportParams("课程列表", "导出人:Jeecg",
                "导出信息"));
        map.put(NormalExcelConstants.DATA_LIST,courses);
        return NormalExcelConstants.JEECG_EXCEL_VIEW;
    }


}
