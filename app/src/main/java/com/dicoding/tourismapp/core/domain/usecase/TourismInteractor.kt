package com.dicoding.tourismapp.core.domain.usecase

import androidx.lifecycle.LiveData
import com.dicoding.tourismapp.core.data.Resource
import com.dicoding.tourismapp.core.data.TourismRepository
import com.dicoding.tourismapp.core.domain.model.Tourism
import com.dicoding.tourismapp.core.domain.repository.ITourismRepository
import javax.inject.Inject

class TourismInteractor @Inject constructor(private val tourismRepository: ITourismRepository): TourismUseCase {
    override fun getAllTourism() = tourismRepository.getAllTourism()

    override fun getFavoriteTourism() = tourismRepository.getFavoriteTourism()

    override fun setFavoriteTourism(tourism: Tourism, state: Boolean) = tourismRepository.setFavoriteTourism(tourism, state)

}