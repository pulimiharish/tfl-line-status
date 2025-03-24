package com.tfl.linestatus.navigation

import android.net.Uri
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.tfl.linestatus.statusdetail.ui.LineStatusDetailsScreen
import com.tfl.linestatus.statuslist.ui.LineStatusListScreen

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun LineStatusNavHost() {
    val navController = rememberAnimatedNavController()

    AnimatedNavHost(
        navController = navController,
        startDestination = LineStatusDestinations.LINE_STATUS_LIST_ROUTE
    ) {
        composable(
            route = LineStatusDestinations.LINE_STATUS_LIST_ROUTE,
            enterTransition = {
                slideInHorizontally(initialOffsetX = { -it }) + fadeIn(initialAlpha = 0.3f)
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { it }) + fadeOut(targetAlpha = 0.3f)
            }
        ) {
            LineStatusListScreen { name, status, reason ->
                navController.navigate(lineStatusDetailsRoute(name, status, reason))
            }
        }

        composable(
            route = LineStatusDestinations.LINE_STATUS_DETAILS_ROUTE,
            arguments = listOf(
                navArgument(LineStatusDestinations.LineStatusNavArgs.NAME) {
                    type = NavType.StringType
                },
                navArgument(LineStatusDestinations.LineStatusNavArgs.STATUS) {
                    type = NavType.StringType
                },
                navArgument(LineStatusDestinations.LineStatusNavArgs.REASON) {
                    type = NavType.StringType
                }),
            enterTransition = {
                slideInHorizontally(initialOffsetX = { it }) + fadeIn(initialAlpha = 0.3f)
            },
            exitTransition = {
                slideOutHorizontally(targetOffsetX = { -it }) + fadeOut(targetAlpha = 0.3f)
            }
        ) { backStackEntry ->
            val name = Uri.decode(backStackEntry.arguments?.getString(LineStatusDestinations.LineStatusNavArgs.NAME))
            val status = Uri.decode(backStackEntry.arguments?.getString(LineStatusDestinations.LineStatusNavArgs.STATUS))
            val reason = Uri.decode(backStackEntry.arguments?.getString(LineStatusDestinations.LineStatusNavArgs.REASON))
            name?.let { name ->
                LineStatusDetailsScreen(
                    name = name,
                    status = status ?: "",
                    reason = reason ?: "",
                    onBackPressed = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}
