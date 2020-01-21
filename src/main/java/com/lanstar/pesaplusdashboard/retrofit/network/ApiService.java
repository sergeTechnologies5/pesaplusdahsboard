package com.lanstar.tablebank.network;

import com.lanstar.tablebank.model.ActiveLoan;
import com.lanstar.tablebank.model.Employer;
import com.lanstar.tablebank.model.Group;
import com.lanstar.tablebank.model.Loan;
import com.lanstar.tablebank.model.MemberType;
import com.lanstar.tablebank.model.MobileTrxn;
import com.lanstar.tablebank.model.ShareBalance;
import com.lanstar.tablebank.model.Summary;
import com.lanstar.tablebank.model.TellerTrxn;
import com.lanstar.tablebank.model.Title;
import com.lanstar.tablebank.network.model.ApproveLoanRequest;
import com.lanstar.tablebank.network.model.ChangePwdRequest;
import com.lanstar.tablebank.network.model.GeneralResponse;
import com.lanstar.tablebank.network.model.GroupBank;
import com.lanstar.tablebank.network.model.BosaRequest;
import com.lanstar.tablebank.network.model.LoanAppraiseRequest;
import com.lanstar.tablebank.network.model.PaymentRequest;
import com.lanstar.tablebank.network.model.PostLoanRequest;
import com.lanstar.tablebank.network.model.RejectLoanRequest;
import com.lanstar.tablebank.network.model.ResetPwdRequest;
import com.lanstar.tablebank.network.model.SearchMemberRequest;
import com.lanstar.tablebank.network.model.SignInRequest;
import com.lanstar.tablebank.model.Member;
import com.lanstar.tablebank.model.TellerEod;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    // ------------------------------ MEMBERS -------------------------------------//

    // Register Member
    @POST("api/member/register/{groupId}")
    Call<String> createMember(@Body Member member, @Path("groupId") int group);

    @PUT("api/member/update/{memberId}")
    Call<String> updateMember(@Body Member member, @Path("memberId") String memberNo);

    // List all group Members
    @GET("api/member/{groupId}")
    Call<String> loadMembers(@Path("groupId") int group);

    // View Member by Id
    @GET("api/member/viewone/{groupId}/{memberNo}")
    Call<String> findMemberById(@Path("groupId") int group, @Path("memberNo") String memberNo);

    @GET("api/member/types")
    Call<List<MemberType>> getMemberTypes();

    @GET("api/member/titles")
    Call<List<Title>> getTitles();

    @GET("api/member/employers")
    Call<List<Employer>> getEmployers();

    @POST("api/member/search")
    Call<Member> searchMember(@Body SearchMemberRequest request);

    @POST("api/member/register")
    Call<GeneralResponse> SaveNewMember(@Body Member member);

    // ---------------------------------------------------------------------------------------------

    // ---------------------------- CONTRIBUTIONS ----------------------------------//

    @POST("api/teller/post-txn")
    Call<GeneralResponse> postMobileTrxn(@Body MobileTrxn mobileTrxn);

    @POST("api/teller/teller-txn")
    Call<GeneralResponse> postTellerTrxn(@Body MobileTrxn mobileTrxn);

    // ---------------------------------------------------------------------------------------------

    // ---------------------------- LOANS ------------------------------------------//

    // Appraise Loan
    @POST("api/loan/appraise/{memberNo}")
    Call<String> requestLoan(@Body LoanAppraiseRequest payment, @Path("memberNo") String memberId);

    // Approve / Reject Loan
    @POST("api/loan/approve")
    Call<GeneralResponse> approveLoan(@Body ApproveLoanRequest loan);

    @POST("api/loan/reject")
    Call<GeneralResponse> rejectLoan(@Body RejectLoanRequest loan);

    @POST("api/loan/post")
    Call<GeneralResponse> postLoan(@Body PostLoanRequest request);

    @POST("api/loan/{status}")
    Call<List<Loan>> getLoans( @Path("status") String status, @Body Group group);

    // View Loan by Id
    @GET("api/loan/view/{id}")
    Call<String> getMemberDetailsFromLoan(@Path("id") int id);

    @POST("api/loan/member/shares")
    Call<String> getGuarantorShares(@Body BosaRequest request);

    // Loan types
    @GET("api/loan/types")
    Call<String> getLoanTypes();

    // ---------------------------------------------------------------------------------------------

    // -------------------------------- GROUPS -------------------------------------//

    // List all groups
    @GET("api/groups")
    Call<String> getGroups();

    @GET("api/group/summary/{group_no}")
    Call<String> getGroupShares(@Path("group_no") int group_no);


    // ---------------------------------------------------------------------------------------------

    // -------------------------------- USER ACCOUNTS ------------------------------ //

    // Sign In
    @POST("api/auth/signin")
    Call<String> login(@Body SignInRequest request);

    // Change Password
    @POST("api/user/change/password")
    Call<String> changePassword(@Body ChangePwdRequest request);

    // Request Password Reset
    @POST("api/user/request/new/password")
    Call<String> requestReset(@Body ResetPwdRequest request);

    // ---------------------------------------------------------------------------------------------

    // ------------------------------ SCHEMES ------------------------------------- //

    // Get all Schemes
    @GET("/api/scheme")
    Call<String> loadSchemes();

    // ------------------------------ SAVINGS ------------------------------------- //

    // ---------------------------------------------------------------------------------------------

    @POST("api/member/share-balance")
    Call<List<ShareBalance>> GetMemberShareBalance(@Body BosaRequest request);

    @POST("api/member/loan-balance")
    Call<List<ActiveLoan>> getMemberLoanBalances(@Body BosaRequest request);

    // ---------------------------------------------------------------------------------------------

    // ------------------------------ EOD ------------------------------------- //

    // POST EoD
    @POST("api/user/post/eod/{group_no}")
    Call<String> postEoD(@Body TellerEod tellerEod, @Path("group_no") Integer group_no);

    // Report

    @GET("api/teller/view-txn")
    Call<List<TellerTrxn>> getTellerTrans();

    @POST("api/member/bosa/statement")
    Call<String> BOSAStatement(@Body BosaRequest request);

    @GET("api/group/summary/{groupNo}")
    Call<Summary> getSummary(@Path("groupNo") String group_no);

}
