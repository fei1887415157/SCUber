/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.compose.jetsurvey.survey

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.compose.jetsurvey.R
import com.example.compose.jetsurvey.survey.question.DateQuestion
import com.example.compose.jetsurvey.survey.question.MultipleChoiceQuestion
import com.example.compose.jetsurvey.survey.question.PhotoQuestion
import com.example.compose.jetsurvey.survey.question.SingleChoiceQuestion
import com.example.compose.jetsurvey.survey.question.SliderQuestion
import com.example.compose.jetsurvey.survey.question.MBTI



// Q1: In my free time I like to ...
@Composable
fun FreeTimeQuestion(
    selectedAnswers: List<Int>,
    onOptionSelected: (selected: Boolean, answer: Int) -> Unit,
    modifier: Modifier = Modifier,
) {
    MultipleChoiceQuestion(
        titleResourceId = R.string.in_my_free_time,
        directionsResourceId = R.string.select_all,
        possibleAnswers = listOf(
            R.string.sports,
            R.string.work_out,
            R.string.read,
            R.string.draw,
            R.string.dance,
            R.string.play_games,
            R.string.watch_movies,
            R.string.others,
        ),
        selectedAnswers = selectedAnswers,
        onOptionSelected = onOptionSelected,
        modifier = modifier,
    )
}



// Q2: What is your MBTI personality type?
@Composable
fun YourMBTIQuestion(
    selectedAnswer: MBTI?,
    onOptionSelected: (MBTI) -> Unit,
    modifier: Modifier = Modifier,
) {
    SingleChoiceQuestion(
        titleResourceId = R.string.your_MBTI,
        directionsResourceId = R.string.select_one,
        possibleAnswers = listOf(
            MBTI(R.string.INTJ, R.drawable.intj),
            MBTI(R.string.ENTJ, R.drawable.entj),
            MBTI(R.string.ISFP, R.drawable.isfp),
            MBTI(R.string.ESFP, R.drawable.esfp),
            MBTI(R.string.INFJ, R.drawable.infj),
            MBTI(R.string.ENFJ, R.drawable.enfj),
            MBTI(R.string.ISTP, R.drawable.istp),
            MBTI(R.string.ESTP, R.drawable.estp),
            MBTI(R.string.ISTJ, R.drawable.istj),
            MBTI(R.string.ESTJ, R.drawable.estj),
            MBTI(R.string.INFP, R.drawable.infp),
            MBTI(R.string.ENFP, R.drawable.enfp),
            MBTI(R.string.ISFJ, R.drawable.isfj),
            MBTI(R.string.ESFJ, R.drawable.esfj),
            MBTI(R.string.INTP, R.drawable.intp),
            MBTI(R.string.ENTP, R.drawable.entp),
        ),
        selectedAnswer = selectedAnswer,
        onOptionSelected = onOptionSelected,
        modifier = modifier,
    )
}

@Composable
fun TakeawayQuestion(
    dateInMillis: Long?,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    DateQuestion(
        titleResourceId = R.string.takeaway,
        directionsResourceId = R.string.select_date,
        dateInMillis = dateInMillis,
        onClick = onClick,
        modifier = modifier,
    )
}

@Composable
fun FeelingAboutSelfiesQuestion(
    value: Float?,
    onValueChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    SliderQuestion(
        titleResourceId = R.string.selfies,
        value = value,
        onValueChange = onValueChange,
        startTextResource = R.string.strongly_dislike,
        neutralTextResource = R.string.neutral,
        endTextResource = R.string.strongly_like,
        modifier = modifier,
    )
}

@Composable
fun TakeSelfieQuestion(
    imageUri: Uri?,
    getNewImageUri: () -> Uri,
    onPhotoTaken: (Uri) -> Unit,
    modifier: Modifier = Modifier,
) {
    PhotoQuestion(
        titleResourceId = R.string.selfie_skills,
        imageUri = imageUri,
        getNewImageUri = getNewImageUri,
        onPhotoTaken = onPhotoTaken,
        modifier = modifier,
    )
}
