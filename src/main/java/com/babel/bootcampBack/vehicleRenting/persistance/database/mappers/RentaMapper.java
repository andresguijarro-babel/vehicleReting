package com.babel.bootcampBack.vehicleRenting.persistance.database.mappers;

import com.babel.bootcampBack.vehicleRenting.models.Renta;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

@Mapper
public interface RentaMapper {
    @Insert("INSERT INTO RENTA_ANUAL (PERSONA_ID,PROFESION_ID, ANIO, IMPORTE, IS_CUENTA_PROPIA,IAE,CIF_EMPLEADOR,FECHA_INICIO_EMPLEO) VALUES(#{personaId},#{profesionId},#{anio},#{importe},#{isCuentaPropia},#{iae, jdbcType=CHAR},#{cifEmpleador},#{fechaInicioEmpleo, jdbcType=DATE})")
    @Options(useGeneratedKeys = true, keyProperty = "rentaId", keyColumn = "RENTA_ID")
    void addRenta(Renta renta);
}
