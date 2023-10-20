package com.example.simplecsvimportexport

import com.google.gson.annotations.SerializedName

data class CsvExampleItem(

    @SerializedName("order_id") var orderId: String? = null,
    @SerializedName("invoice") var invoice: String? = null,
    @SerializedName("invoice_date") var invoiceDate: String? = null,
    @SerializedName("Payment_type") var PaymentType: String? = null,
    @SerializedName("Patient_id") var PatientId: String? = null,
    @SerializedName("Doctor_id") var DoctorId: String? = null,
    @SerializedName("Medicine_id") var MedicineId: String? = null,
    @SerializedName("Batch_number") var BatchNumber: String? = null,
    @SerializedName("Expiry") var Expiry: String? = null,
    @SerializedName("cost_price") var costPrice: Double? = null,
    @SerializedName("MRP") var MRP: Double? = null,
    @SerializedName("quantity") var quantity: Int? = null,
    @SerializedName("loose") var loose: Int? = null,
    @SerializedName("cgst") var cgst: Double? = null,
    @SerializedName("sgst") var sgst: Double? = null,
    @SerializedName("igst") var igst: Double? = null,
    @SerializedName("cess") var cess: Double? = null,
    @SerializedName("disc_per") var discPer: Double? = null,
    @SerializedName("BarCode") var BarCode: String? = null,
    @SerializedName("order_item_id") var orderItemId: String? = null,
    @SerializedName("cgst_value") var cgstValue: Double? = null,
    @SerializedName("sgst_value") var sgstValue: Double? = null,
    @SerializedName("igst_value") var igstValue: Double? = null,
    @SerializedName("cess_value") var cessValue: Double? = null,
    @SerializedName("net_gst_value") var netGstValue: Double? = null,
    @SerializedName("amount") var amount: Double? = null,
    @SerializedName("point_earn") var pointEarn: Double? = null,
    @SerializedName("point_redeem") var pointRedeem: Double? = null

)