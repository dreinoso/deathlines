package com.reactions.deathlines.presentation.ui.features.goals

import com.reactions.deathlines.domain.usecase.album.GetAlbumsUseCase
import com.reactions.deathlines.presentation.ui.base.BaseViewModel
import javax.inject.Inject

class GoalsViewModel @Inject constructor(private val getAlbumsUseCase: GetAlbumsUseCase) : BaseViewModel() {

}