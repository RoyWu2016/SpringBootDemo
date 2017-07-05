package com.roy.utils;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.roy.enums.ResultEnum;
import com.roy.exception.MyException;

/**
 * Created by ldj on 2017/7/5.
 */
public class ProtoStuffUtil{

    public static <T> byte[] serializer(T o) {
        Schema schema = RuntimeSchema.getSchema(o.getClass());
        return ProtostuffIOUtil.toByteArray(o,schema,LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
    }

    public static <T> T deserializer(byte[] bytes, Class<T> clazz) throws MyException{
        T obj = null;
        try {
            obj = clazz.newInstance();
            Schema schema = RuntimeSchema.getSchema(obj.getClass());
            ProtostuffIOUtil.mergeFrom(bytes,obj,schema);
        } catch (InstantiationException e) {
            throw new MyException(ResultEnum.FAIL);
        } catch (IllegalAccessException e) {
            throw new MyException(ResultEnum.FAIL);
        }

        return obj;
    }
}
