package org.proyecto.sav.model;

//enum que representa los estados del pago.
public enum PaymentStatus {

    //el pago esta registrado pero aun no procesado
    PENDIENTE,

    //el pago fue aprobado exitosamente
    APROBADO,

    //el pago fue rechazado por algun motivo
    RECHAZADO,

    //el pago fue reembolsado al cliente
    REEMBOLSADO
}
