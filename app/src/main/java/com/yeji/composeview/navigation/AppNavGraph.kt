package com.yeji.composeview.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.yeji.composeview.ui.screen.SignInScreen

@Composable
fun AppNavGraph(
    startDestination: String = AppDestinations.SignIn
) {
    val navController = rememberNavController()
    val destinations = AppDestinations

    NavHost(
        navController = navController,
        startDestination = startDestination,
    ) {
        signInDestination(destinations)
        signUpDestination(destinations)
        mainDestination(destinations)
    }
}


private fun NavGraphBuilder.signInDestination(
    destinations: AppDestinations
) {
    composable(route = destinations.SignIn) {
        SignInScreen()
    }
}

private fun NavGraphBuilder.signUpDestination(
    destinations: AppDestinations
) {
    composable(route = destinations.SignUp) {
        SignInScreen()
    }
}

private fun NavGraphBuilder.mainDestination(
    destinations: AppDestinations
) {
    composable(route = destinations.Main) {
        SignInScreen()
    }
}