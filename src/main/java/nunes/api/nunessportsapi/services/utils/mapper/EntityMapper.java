package nunes.api.nunessportsapi.services.utils.mapper;

import org.modelmapper.ModelMapper;

public class EntityMapper {

  private static final ModelMapper modelMapper = new ModelMapper();

  public static <D, S> D mapToDto(S source, Class<D> destinationType) {
    return modelMapper.map(source, destinationType);
  }

  public static <D, S> D mapToEntity(S source, Class<D> destinationType) {
    return modelMapper.map(source, destinationType);
  }
}
