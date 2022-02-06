package com.producter.basketballteam.service;


import com.producter.basketballteam.entity.Position;
import com.producter.basketballteam.exception.PositionNotFoundException;
import com.producter.basketballteam.model.dto.PositionDto;
import com.producter.basketballteam.model.request.PositionCreateRequest;
import com.producter.basketballteam.repository.PositionRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PositionService {

    private final PositionRepository repository;
    private final ModelMapper modelMapper;

    public PositionService(PositionRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public List<PositionDto> getAllPositions(){
        return repository.findAll().stream().map(position -> modelMapper.map(position,PositionDto.class)).collect(Collectors.toList());
    }

    public PositionDto createPosition(PositionCreateRequest request){
        return modelMapper.map(repository.save(modelMapper.map(request, Position.class)),PositionDto.class);
    }

    public PositionDto updatePositionById(PositionCreateRequest request,Long id){

        Position existPosition = findPositionById(id);
        Position updatePosition = new Position(existPosition.getId(),request.getPosition());

        return modelMapper.map(repository.save(updatePosition),PositionDto.class);
    }

    public void deletePositionById(Long id){
        repository.delete(findPositionById(id));
    }

    public Position findPositionById(Long id){
        return repository.findById(id).orElseThrow(()->new PositionNotFoundException("position not found id:"+id));
    }

}
