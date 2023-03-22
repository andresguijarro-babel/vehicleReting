package com.babel.bootcampBack.vehicleRenting.services.impl;

import com.babel.bootcampBack.vehicleRenting.models.Renta;
import com.babel.bootcampBack.vehicleRenting.persistance.database.mappers.RentaMapper;
import com.babel.bootcampBack.vehicleRenting.services.RentaService;
import org.springframework.stereotype.Service;

@Service
public class RentaServiceImpl implements RentaService {
    RentaMapper rentaMapper;

    public RentaServiceImpl(RentaMapper rentaMapper) {
        this.rentaMapper = rentaMapper;
    }

    @Override
    public Renta addRenta(Renta renta) {
        this.rentaMapper.addRenta(renta);
        return renta;
    }

}
