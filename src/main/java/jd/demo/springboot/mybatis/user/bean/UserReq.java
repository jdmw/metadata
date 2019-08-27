package jd.demo.springboot.mybatis.user.bean;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserReq {

    /**
     * 唯一标示
     */
    private Long id;
    /**
     * 编码
     */
    private String code;
    /**
     * 名称
     */
    private String name;
    /**
     * 状态 1启用 0 停用
     */
    private String status;
    /**
     * 创建时间
     */
    private Date gmtCreate;
    /**
     * 修改时间
     */
    private Date gmtModified;

}
