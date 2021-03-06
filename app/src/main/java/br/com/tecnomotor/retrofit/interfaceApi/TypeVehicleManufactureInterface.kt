package br.com.tecnomotor.retrofit.interfaceApi

import br.com.tecnomotor.utils.Constant.URL_TYPE_VEHICLE_MANUFACTURE
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface TypeVehicleManufactureInterface {
    @Headers("Content-Type: application/json")
    @GET(URL_TYPE_VEHICLE_MANUFACTURE)
    fun getTypeAutomobileManufacture(): Call<ArrayList<String>>

}