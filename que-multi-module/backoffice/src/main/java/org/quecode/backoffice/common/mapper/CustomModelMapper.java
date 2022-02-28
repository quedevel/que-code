package org.quecode.backoffice.common.mapper;

import org.modelmapper.ModelMapper;

import java.util.Objects;

public class CustomModelMapper extends ModelMapper {

    /**
     * dto to entity || entity to dto
     * @param source
     * @param destinationType
     * @param <D>
     * @return D
     */
    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        if(Objects.isNull(source)){
            source = new Object();
        }
        return super.map(source, destinationType);
    }
}
