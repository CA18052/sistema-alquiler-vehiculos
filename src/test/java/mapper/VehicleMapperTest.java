package mapper;

import org.junit.jupiter.api.Test;
import org.proyecto.sav.dto.VehicleDTO;
import org.proyecto.sav.mapper.VehicleMapper;
import org.proyecto.sav.model.Vehicle;
import org.proyecto.sav.model.VehicleStatus;

import static org.junit.jupiter.api.Assertions.*;

class VehicleMapperTest {

    @Test
    void toDTO_debeConvertirCorrectamente() {

        // Crear entidad Vehicle simulada
        Vehicle v = new Vehicle();
        v.setId(1L);
        v.setPlate("P123-456");
        v.setBrand("Toyota");
        v.setModel("Corolla");
        v.setStatus(VehicleStatus.DISPONIBLE);

        // Usar el mapper real
        VehicleDTO dto = VehicleMapper.toDTO(v);

        // Verificar conversión
        assertNotNull(dto);
        assertEquals(1L, dto.id());
        assertEquals("P123-456", dto.plate());
        assertEquals("Toyota", dto.brand());
        assertEquals("Corolla", dto.model());
        assertEquals("DISPONIBLE", dto.status());
    }
}
