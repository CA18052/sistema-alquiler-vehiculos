package service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.proyecto.sav.dto.VehicleDTO;
import org.proyecto.sav.mapper.VehicleMapper;
import org.proyecto.sav.model.Vehicle;
import org.proyecto.sav.model.VehicleStatus;
import org.proyecto.sav.repository.VehicleRepository;
import org.proyecto.sav.service.VehicleService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VehicleServiceTest {

    @Mock
    private VehicleRepository vehicleRepository;

    @InjectMocks
    private VehicleService vehicleService;

    public VehicleServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    // -------------------------------------------------------------
    // TEST 1: LISTAR VEHICULOS
    // -------------------------------------------------------------
    @Test
    void list_debeRetornarListaDeDTOs() {

        Vehicle v = new Vehicle();
        v.setId(1L);
        v.setPlate("P123");
        v.setBrand("Honda");
        v.setModel("Civic");
        v.setStatus(VehicleStatus.DISPONIBLE);

        when(vehicleRepository.findAll()).thenReturn(List.of(v));

        List<VehicleDTO> result = vehicleService.list();

        assertEquals(1, result.size());
        assertEquals("Honda", result.get(0).brand());
        assertEquals("Civic", result.get(0).model());
    }

    // -------------------------------------------------------------
    // TEST 2: CREAR VEHICULO (EXITOSO)
    // -------------------------------------------------------------
    @Test
    void create_debeGuardarYRetornarDTO() {

        VehicleDTO dto = new VehicleDTO(
                null,
                "P999",
                "Toyota",
                "Corolla",
                "DISPONIBLE"
        );

        Vehicle entity = VehicleMapper.toEntity(dto);
        entity.setId(10L);

        when(vehicleRepository.existsByPlate("P999")).thenReturn(false);
        when(vehicleRepository.save(any())).thenReturn(entity);

        VehicleDTO result = vehicleService.create(dto);

        assertNotNull(result);
        assertEquals("P999", result.plate());
        assertEquals("Toyota", result.brand());
        assertEquals(10L, result.id());
    }

    // -------------------------------------------------------------
    // TEST 3: CREAR VEHICULO CON PLACA DUPLICADA
    // -------------------------------------------------------------
    @Test
    void create_debeLanzarExcepcionSiPlacaExiste() {

        VehicleDTO dto = new VehicleDTO(
                null,
                "P123",
                "Nissan",
                "Versa",
                "DISPONIBLE"
        );

        when(vehicleRepository.existsByPlate("P123")).thenReturn(true);

        assertThrows(IllegalArgumentException.class, () -> {
            vehicleService.create(dto);
        });
    }

    // -------------------------------------------------------------
    // TEST 4: BUSCAR POR ID (EXITOSO)
    // -------------------------------------------------------------
    @Test
    void findByIdOrThrow_debeRetornarVehiculo() {

        Vehicle v = new Vehicle();
        v.setId(5L);

        when(vehicleRepository.findById(5L)).thenReturn(Optional.of(v));

        Vehicle result = vehicleService.findByIdOrThrow(5L);

        assertNotNull(result);
        assertEquals(5L, result.getId());
    }

    // -------------------------------------------------------------
    // TEST 5: BUSCAR POR ID QUE NO EXISTE
    // -------------------------------------------------------------
    @Test
    void findByIdOrThrow_debeLanzarExcepcion() {

        when(vehicleRepository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(IllegalArgumentException.class, () -> {
            vehicleService.findByIdOrThrow(99L);
        });
    }

}