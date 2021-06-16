package com.lqz.demo.config;



import com.google.common.base.Stopwatch;
import io.protostuff.LinkedBuffer;
import io.protostuff.ProtobufIOUtil;
import io.protostuff.Schema;
import io.protostuff.runtime.RuntimeSchema;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.util.zip.GZIPOutputStream;

/**
 * @author liaoqinzhou_sz
 * @version 1.0.0
 * @Description TODO
 * @createTime 2021年06月16日 17:10:00
 */
public class ProtostuffHttpMessageConverter extends AbstractHttpMessageConverter<Object> {
    private Logger logger = LoggerFactory.getLogger(getClass());
    public static final Charset DEFAULT_CHARSET = Charset.forName("UTF-8");
    public static final MediaType MEDIA_TYPE = new MediaType("application", "x-protobuf", DEFAULT_CHARSET);
    public static final MediaType MEDIA_TYPE_GZIP = new MediaType("application", "x-protobuf-gzip", DEFAULT_CHARSET);


    public ProtostuffHttpMessageConverter() {
        super(MEDIA_TYPE, MEDIA_TYPE_GZIP);
    }


    @Override
    public boolean canRead(final Class<?> clazz, final MediaType mediaType) {
        return canRead(mediaType);
    }


    @Override
    public boolean canWrite(final Class<?> clazz, final MediaType mediaType) {
        return canWrite(mediaType);
    }


    @Override
    protected Object readInternal(final Class<?> clazz, final HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        if (MEDIA_TYPE.isCompatibleWith(inputMessage.getHeaders().getContentType())) {
            final Schema<?> schema = RuntimeSchema.getSchema(clazz);

            final Object value = schema.newMessage();

            try (final InputStream stream = inputMessage.getBody()) {
                ProtobufIOUtil.mergeFrom(stream, value, (Schema<Object>) schema);

                return value;
            }
        }

        throw new HttpMessageNotReadableException(
                "Unrecognized HTTP media type " + inputMessage.getHeaders().getContentType().getType() + ".");
    }


    @Override
    protected boolean supports(final Class<?> clazz) {
        throw new UnsupportedOperationException();
    }


    @Override
    protected void writeInternal(final Object o, final HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        logger.info("Current type: {}", outputMessage.getHeaders().getContentType());
        Stopwatch stopwatch = Stopwatch.createStarted();
        OutputStream stream = null;

        try {
            stream = outputMessage.getBody();
            if (MEDIA_TYPE.isCompatibleWith(outputMessage.getHeaders().getContentType())) {
            } else if (MEDIA_TYPE_GZIP.isCompatibleWith(outputMessage.getHeaders().getContentType())) {
                stream = new GZIPOutputStream(stream);
            } else {
                throw new HttpMessageNotWritableException(
                        "Unrecognized HTTP media type " + outputMessage.getHeaders().getContentType().getType() + ".");
            }

            ProtobufIOUtil.writeTo(stream, o, RuntimeSchema.getSchema((Class<Object>) o.getClass()),
                    LinkedBuffer.allocate());
            stream.flush();
        } finally {
            IOUtils.closeQuietly(stream);
        }

        logger.info("Output spend {}", stopwatch.toString());
    }
}