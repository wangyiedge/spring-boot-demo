package cn.me.edge.model.reponse;

import lombok.Data;

/**
 * <p>基础返回结果</p>
 *
 * @author sprainkle
 * @date 2019/5/2
 */
@Data
public class BaseResponse {
    /**
     * 返回码
     */
    protected int code;
    /**
     * 返回消息
     */
    protected String message;
    /**
     * 时间戳
     */
    protected long timestamp;

    public BaseResponse() {
        // 默认创建成功的回应
        this(200, "成功");
    }

//    public BaseResponse(IResponseEnum responseEnum) {
//        this(responseEnum.getCode(), responseEnum.getMessage());
//    }

    public BaseResponse(int code, String message) {
        this.code = code;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

}
