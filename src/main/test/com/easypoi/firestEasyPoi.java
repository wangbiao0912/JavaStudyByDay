package com.easypoi;

import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.junit.Test;

/**
 * Created by pc5 on 2017/3/23.
 * 导出表格工具
 */
public class firestEasyPoi {
    @Test
    public void downlaodPoi()
    {

        System.out.print("11111111");
        /**
         * 2.基础导出    传入导出参数,导出对象,以及对象列表即可完成导出

         HSSFWorkbook workbook = ExcelExportUtil.exportExcel(new ExportParams(
         "2412312", "测试", "测试"), CourseEntity.class, list);
         3.基础导出,带有索引    在到处参数设置一个值,就可以在导出列增加索引

         ExportParams params = new ExportParams("2412312", "测试", "测试");
         params.setAddIndex(true);
         HSSFWorkbook workbook = ExcelExportUtil.exportExcel(params,
         TeacherEntity.class, telist);
         4.导出Map    创建类似注解的集合,即可完成Map的导出,略有麻烦

         List<ExcelExportEntity> entity = new ArrayList<ExcelExportEntity>();
         entity.add(new ExcelExportEntity("姓名", "name"));
         entity.add(new ExcelExportEntity("性别", "sex"));

         List<Map<String, String>> list = new ArrayList<Map<String, String>>();
         Map<String, String> map;
         for (int i = 0; i < 10; i++) {
         map = new HashMap<String, String>();
         map.put("name", "1" + i);
         map.put("sex", "2" + i);
         list.add(map);
         }

         HSSFWorkbook workbook = ExcelExportUtil.exportExcel(new ExportParams(
         "测试", "测试"), entity, list);
         5.模板导出    根据模板配置,完成对应导出

         TemplateExportParams params = new TemplateExportParams();
         params.setHeadingRows(2);
         params.setHeadingStartRow(2);
         Map<String,Object> map = new HashMap<String, Object>();
         map.put("year", "2013");
         map.put("sunCourses", list.size());
         Map<String,Object> obj = new HashMap<String, Object>();
         map.put("obj", obj);
         obj.put("name", list.size());
         params.setTemplateUrl("org/jeecgframework/poi/excel/doc/exportTemp.xls");
         Workbook book = ExcelExportUtil.exportExcel(params, CourseEntity.class, list,
         map);
         6.导入    设置导入参数,传入文件或者流,即可获得相应的list

         ImportParams params = new ImportParams();
         params.setTitleRows(2);
         params.setHeadRows(2);
         //params.setSheetNum(9);
         params.setNeedSave(true);
         long start = new Date().getTime();
         List<CourseEntity> list = ExcelImportUtil.importExcel(new File(
         "d:/tt.xls"), CourseEntity.class, params);
         7.和spring mvc的无缝融合    简单几句话,Excel导出搞定

         @RequestMapping(params = "exportXls")
         public String exportXls(CourseEntity course,HttpServletRequest request,HttpServletResponse response
         , DataGrid dataGrid,ModelMap map) {

         CriteriaQuery cq = new CriteriaQuery(CourseEntity.class, dataGrid);
         org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, course, request.getParameterMap());
         List<CourseEntity> courses = this.courseService.getListByCriteriaQuery(cq,false);

         map.put(NormalExcelConstants.FILE_NAME,"用户信息");
         map.put(NormalExcelConstants.CLASS,CourseEntity.class);
         map.put(NormalExcelConstants.PARAMS,new ExportParams("课程列表", "导出人:Jeecg",
         "导出信息"));
         map.put(NormalExcelConstants.DATA_LIST,courses);
         return NormalExcelConstants.JEECG_EXCEL_VIEW;

         }
         */

    }
}


