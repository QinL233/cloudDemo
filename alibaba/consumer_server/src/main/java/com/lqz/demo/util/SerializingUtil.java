package com.lqz.demo.util;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月15日 09:33:00
 */

import io.protostuff.LinkedBuffer;
import io.protostuff.ProtostuffIOUtil;
import io.protostuff.runtime.RuntimeSchema;

/**
 * 序列化和反序列化工具类
 *
 * @author nathan
 * @date 2019/3/17
 */
public class SerializingUtil {

    /**
     * 将目标类序列化为byte数组
     *
     * @param source
     * @param <T>
     * @return
     */
    public static <T> byte[] serialize(T source) {
        RuntimeSchema<T> schema;
        LinkedBuffer buffer = null;
        byte[] result;
        try {
            schema = RuntimeSchema.createFrom((Class<T>) source.getClass());
            buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
            result = ProtostuffIOUtil.toByteArray(source, schema, buffer);
        } catch (Exception e) {
            throw new RuntimeException("serialize exception");
        } finally {
            if (buffer != null) {
                buffer.clear();
            }
        }

        return result;
    }

    /**
     * 将byte数组反序列化为目标类
     *
     * @param source
     * @param typeClass
     * @param <T>
     * @return
     */
    public static <T> T deserialize(byte[] source, Class<T> typeClass) {
        RuntimeSchema<T> schema;
        T newInstance;
        try {
            schema = RuntimeSchema.createFrom(typeClass);
            newInstance = typeClass.newInstance();
            ProtostuffIOUtil.mergeFrom(source, newInstance, schema);
        } catch (Exception e) {
            throw new RuntimeException("deserialize exception");
        }

        return newInstance;
    }
}