package com.alibaba.rsocket.encoding;

import com.alibaba.rsocket.metadata.RSocketMimeType;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


/**
 * RSocket Mime type encoding Handler
 *
 * @author leijuan
 */
public interface ObjectEncodingHandler {
    ByteBuf EMPTY_BUFFER = Unpooled.EMPTY_BUFFER;

    /**
     * rsocket mime type
     *
     * @return rsocket mime type
     */
    @NotNull
    RSocketMimeType mimeType();

    /**
     * encoding params
     *
     * @param args arguments
     * @return byte buffer
     * @throws Exception exception
     */
    ByteBuf encodingParams(@Nullable Object[] args) throws Exception;

    /**
     * decode params, the return value maybe array or single object value
     *
     * @param data          data
     * @param targetClasses target classes
     * @return object array or single object value
     * @throws Exception exception
     */
    @Nullable
    Object decodeParams(ByteBuf data, @Nullable Class<?>... targetClasses) throws Exception;

    /**
     * encode result
     *
     * @param result result
     * @return byte buffer
     * @throws Exception exception
     */
    ByteBuf encodingResult(@Nullable Object result) throws Exception;

    /**
     * decode result
     *
     * @param data        data
     * @param targetClass target class
     * @return result object
     * @throws Exception exception
     */
    @Nullable
    Object decodeResult(ByteBuf data, @Nullable Class<?> targetClass) throws Exception;

}
