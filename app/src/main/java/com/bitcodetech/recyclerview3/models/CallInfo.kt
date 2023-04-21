package com.bitcodetech.recyclerview3.models

data class CallInfo(
    val name : String?,
    val number : String,
    val imageId : Int?,
    val dateTime : Long,
    val type : Byte
) {
    companion object {
        val TYPE_INCOMING = 1
        val TYPE_OUTGOING = 2
    }
}
