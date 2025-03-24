package com.tfl.linestatus.navigation

import android.net.Uri

object LineStatusDestinations {
    const val LINE_STATUS_LIST_ROUTE = "linestatus_list"
    const val LINE_STATUS_DETAILS_ROUTE = "linestatus_details/{name}/{status}/{reason}"

    object LineStatusNavArgs {
        const val NAME = "name"
        const val STATUS = "status"
        const val REASON = "reason"
    }
}

fun lineStatusDetailsRoute(name: String?, status: String?, reason: String?): String {
    val encodedName = Uri.encode(name)
    val encodedStatus = Uri.encode(status)
    val encodedReason = Uri.encode(reason)
    return "linestatus_details/$encodedName/$encodedStatus/$encodedReason"
}