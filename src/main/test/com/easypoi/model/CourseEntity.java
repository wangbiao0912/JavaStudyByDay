package com.easypoi.model;



/**
 * Created by pc5 on 2017/3/23.
 */
/*@ExcelTarget("courseEntity")*/
public class CourseEntity implements java.io.Serializable {
 /*   @ExcelTarget("courseEntity")*/

        /** 主键 */
        private String id;
        /** 课程名称 */
   /*     @Excel(name = "课程名称", orderNum = "1", needMerge = true)*/
        private String name;
        /** 老师主键 */
        /*@ExcelEntity(id = "yuwen")
        @ExcelVerify()
        private TeacherEntity teacher;
        // 老师主键
        @ExcelEntity(id = "shuxue")
        private TeacherEntity shuxueteacher;

        @ExcelCollection(name = "选课学生", orderNum = "4")
        private List<StudentEntity> students;*/
}
