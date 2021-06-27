package com.example.learnspring.bean.api.base

/**
 * @author 崔兴旺
 * @description
 * @date 2021/6/27 12:15
 */
open class BaseApiResponse<Data>(val data:Data,val code:Int=0, val msg:String="success") {

}