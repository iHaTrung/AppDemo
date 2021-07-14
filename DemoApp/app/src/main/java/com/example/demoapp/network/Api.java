package com.example.demoapp.network;


import com.example.demoapp.model.LoginResponse;
import com.example.demoapp.model.ScheduleAddingResponse;
import com.example.demoapp.model.response.AddIrrigationResponse;
import com.example.demoapp.model.response.ChatDataResponse;
import com.example.demoapp.model.response.DeleteIrrigationResponse;
import com.example.demoapp.model.response.EditIrrigationResponse;
import com.example.demoapp.model.response.ForgotPasswordResponse;
import com.example.demoapp.model.response.GetIrrigationFireResponse;
import com.example.demoapp.model.response.GetIrrigationResponse;
import com.example.demoapp.model.response.GroupChatResponse;
import com.example.demoapp.model.response.ScheduleResponse;
import com.example.demoapp.model.response.UpdateDeviceResponse;


import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Api {

    @FormUrlEncoded
    @POST("users/login")
    Call<LoginResponse> apiLogin(@Field("email") String email,
                                 @Field("password") String password,
                                 @Field("device_id") String device_id,
                                 @Field("type") String type);

    @FormUrlEncoded
    @POST("notifications")
    Call<ScheduleAddingResponse> addNotification(@Field("title") String title,
                                                 @Field("content") String content,
                                                 @Field("time_start") String time_start,
                                                 @Field("time_end") String time_end,
                                                 @Field("type") int type,
                                                 @Field("title_address") String title_address,
                                                 @Field("detail_address") String detail_address,
                                                 @Field("latitude") double latitude,
                                                 @Field("longitude") double longitude,
                                                 @Header("Authorization") String authHeader);


    @FormUrlEncoded
    @POST("map")
    Call<AddIrrigationResponse> addIrrigation(
            @Field("title_address") String titleAddress,
            @Field("detail_address") String detailAddress,
            @Field("content") String content,
            @Field("type") int type,
            @Field("local_id") int localId,
            @Field("latitude") double latitude,
            @Field("longitude") double longitude
    );

    @FormUrlEncoded
    @PUT("map/{id}")
    Call<AddIrrigationResponse> editIrrigation(
            @Path("id") int id,
            @Field("content") String content,
            @Field("type") int type,
            @Header("Authorization") String authHeader
    );


    @FormUrlEncoded
    @PUT("users/{id}")
    Call<LoginResponse> editProfile(
            @Path("id") String id,
            @Field("email") String email,
            @Field("password") String password,
            @Field("password_check") String password_check,
            @Field("firstname") String firstname,
            @Field("firstname_kana") String firstname_kana,
            @Field("lastname") String lastname,
            @Field("lastname_kana") String lastname_kana,
            @Field("prefecture_id") int prefecture_id,
            @Field("local_id") int local_id,
            @Field("team_id") int team_id,
            @Field("position_id") int position_id,
            @Header("Authorization") String authHeader
    );

    @FormUrlEncoded
    @PUT("change-status-map/{id}")
    Call<EditIrrigationResponse> changeIrrigation(
            @Path("id") int id,
            @Field("status") int status,
            @Header("Authorization") String authHeader);

    @FormUrlEncoded
    @POST("devices")
    Call<UpdateDeviceResponse> updateDevice(
            @Field("device_id") String device_id,
            @Field("type") int type,
            @Header("Authorization") String authHeader
    );

    @DELETE("map/{id}")
    Call<DeleteIrrigationResponse> deleteIrrigation(
            @Path("id") int id,
            @Header("Authorization") String authHeader

    );

    @GET("fire?")
    Call<GetIrrigationFireResponse> getFireIrrigations(
            @Query("latitude") double latitude,
            @Query("longitude") double longitude,
            @Header("Authorization") String authHeader
    );

    @GET("map/local")
    Call<GetIrrigationResponse> getIrrigation(
            @Header("Authorization") String authHeader
    );


    @GET("notifications")
    Call<ScheduleResponse> userScheduleLoadMore(
            @Query("type") int type,
            @Query("limit") int limit,
            @Query("page") int page,
            @Header("Authorization") String authHeader
    );


    @GET("users/forget-password/{email}")
    Call<ForgotPasswordResponse> userForgotPassword(
            @Path("email") String email
    );

    @GET("notifications")
    Observable<ScheduleResponse> userSchedule(
            @Query("type") int type,
            @Header("Authorization") String authHeader
    );

    @GET("chat-group")
    Call<GroupChatResponse> getChatGroup(
            @Header("Authorization") String authHeader
    );


    @GET("message/{group_id}?")
    Call<ChatDataResponse> getChats(
            @Path("group_id") int groupId,
            @Query("limit") int limit,
            @Header("Authorization") String authHeader
    );

    @GET("message/{group_id}?")
    Call<ChatDataResponse> getBeforeChats(
            @Path("group_id") int groupId,
            @Query("message_id") int messageId,
            @Query("limit") int limit,
            @Header("Authorization") String authHeader
    );
}
