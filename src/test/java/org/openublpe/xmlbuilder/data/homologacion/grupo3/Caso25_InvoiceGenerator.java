package org.openublpe.xmlbuilder.data.homologacion.grupo3;

import org.openublpe.xmlbuilder.data.GeneralData;
import org.openublpe.xmlbuilder.data.InvoiceInputGenerator;
import org.openublpe.xmlbuilder.data.homologacion.HomologacionUtils;
import org.openublpe.xmlbuilder.models.input.standard.DetalleInputModel;
import org.openublpe.xmlbuilder.models.input.standard.invoice.InvoiceInputModel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Factura con 1 items
 */
public class Caso25_InvoiceGenerator implements InvoiceInputGenerator {

    public static InvoiceInputModel INVOICE;

    @Override
    public InvoiceInputModel getInput() {
        if (INVOICE == null) {
            synchronized (this) {
                if (INVOICE == null) {

                    INVOICE = new InvoiceInputModel();
                    INVOICE.setSerie("FF13");
                    INVOICE.setNumero(3);

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(2019, Calendar.NOVEMBER, 9, 8, 30, 0);
                    INVOICE.setFechaEmision(calendar.getTimeInMillis());

                    INVOICE.setFirmante(GeneralData.getFirmante());
                    INVOICE.setProveedor(GeneralData.getProveedor());
                    INVOICE.setCliente(GeneralData.getClienteConRUC());

                    List<DetalleInputModel> detalle = new ArrayList<>();
                    INVOICE.setDetalle(detalle);

                    for (int i = 0; i < 5; i++) {
                        DetalleInputModel item = new DetalleInputModel();
                        detalle.add(item);
                        item.setDescripcion("Item" + (i + 1));
                        item.setCantidad(HomologacionUtils.cantidadRandom());
                        item.setPrecioUnitario(HomologacionUtils.precioUnitarioRandom());
                        item.setTipoIGV(HomologacionUtils.tipoIGVGratuita());
                    }
                }
            }
        }

        return INVOICE;
    }

}
