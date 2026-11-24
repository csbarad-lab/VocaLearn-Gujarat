package com.example.ui.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Calculate
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Quiz
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.minimumInteractiveComponentSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.i18n.UiStrings
import com.example.ui.theme.JetBrainsMonoFamily

data class ImpQaPair(val question: String, val answer: String)

fun parseImpQuestions(raw: String): List<ImpQaPair> {
  if (raw.isBlank()) return emptyList()
  return raw
    .split(Regex("\\n\\s*---\\s*\\n"))
    .mapNotNull { block ->
      val trimmed = block.trim()
      if (trimmed.isEmpty()) return@mapNotNull null
      val lines = trimmed.lines()
      val qLines = mutableListOf<String>()
      val aLines = mutableListOf<String>()
      var inAnswer = false
      for (line in lines) {
        val clean = line.trim()
        when {
          clean.startsWith("A:", ignoreCase = true) -> {
            inAnswer = true
            aLines += clean.removePrefix("A:").removePrefix("a:").trim()
          }
          clean.startsWith("Q:", ignoreCase = true) -> {
            inAnswer = false
            qLines += clean.removePrefix("Q:").removePrefix("q:").trim()
          }
          inAnswer -> aLines += clean
          else -> qLines += clean
        }
      }
      val q = qLines.joinToString("\n").trim()
      val a = aLines.joinToString("\n").trim()
      if (q.isNotEmpty() || a.isNotEmpty()) ImpQaPair(q, a) else null
    }
}

@Composable
fun LearningOutcomesCard(
  title: String,
  outcomesText: String,
  modifier: Modifier = Modifier,
) {
  if (outcomesText.isBlank()) return
  Surface(
    modifier = modifier.fillMaxWidth(),
    shape = MaterialTheme.shapes.medium,
    color = MaterialTheme.colorScheme.tertiaryContainer.copy(alpha = 0.45f),
    border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary.copy(alpha = 0.35f)),
  ) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(14.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        Icon(
          imageVector = Icons.Filled.CheckCircle,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.tertiary,
          modifier = Modifier.size(20.dp),
        )
        Text(
          text = title,
          style = MaterialTheme.typography.titleMedium,
          color = MaterialTheme.colorScheme.onSurface,
        )
      }
      Text(
        text = outcomesText,
        style = MaterialTheme.typography.bodyMedium,
        color = MaterialTheme.colorScheme.onSurface,
      )
    }
  }
}

@Composable
fun ImportantEquationsCard(
  title: String,
  equationsText: String,
  modifier: Modifier = Modifier,
) {
  val equationLines = remember(equationsText) {
    equationsText.lines().map { it.trim() }.filter { it.isNotEmpty() }
  }
  if (equationLines.isEmpty()) return

  Surface(
    modifier = modifier.fillMaxWidth().testTag("lesson_equations_card"),
    shape = MaterialTheme.shapes.medium,
    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.32f),
    border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.38f)),
  ) {
    Column(
      modifier = Modifier.fillMaxWidth().padding(14.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
      ) {
        Icon(
          imageVector = Icons.Filled.Calculate,
          contentDescription = null,
          tint = MaterialTheme.colorScheme.primary,
          modifier = Modifier.size(20.dp),
        )
        Text(
          text = title,
          style = MaterialTheme.typography.titleMedium,
          color = MaterialTheme.colorScheme.primary,
        )
      }
      equationLines.forEach { eq ->
        Surface(
          shape = RoundedCornerShape(10.dp),
          color = MaterialTheme.colorScheme.surface,
          border = BorderStroke(1.dp, MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)),
          modifier = Modifier.fillMaxWidth(),
        ) {
          Text(
            text = eq.removePrefix("•").trim(),
            style = MaterialTheme.typography.bodyMedium.copy(
              fontFamily = JetBrainsMonoFamily,
              fontWeight = FontWeight.Medium,
            ),
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 8.dp),
          )
        }
      }
    }
  }
}

@Composable
fun ImpQuestionsSection(
  lessonId: String,
  impQuestionsRaw: String,
  strings: UiStrings,
  modifier: Modifier = Modifier,
) {
  val pairs = remember(impQuestionsRaw) { parseImpQuestions(impQuestionsRaw) }
  if (pairs.isEmpty()) return

  Column(
    modifier = modifier.fillMaxWidth().testTag("lesson_imp_questions_section"),
    verticalArrangement = Arrangement.spacedBy(8.dp),
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
      Icon(
        imageVector = Icons.Filled.Quiz,
        contentDescription = null,
        tint = MaterialTheme.colorScheme.secondary,
        modifier = Modifier.size(20.dp),
      )
      Text(
        text = strings.impQuestionsTitle,
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.onSurface,
      )
    }

    pairs.forEachIndexed { index, qa ->
      var expanded by remember(lessonId, index) { mutableStateOf(false) }
      Surface(
        shape = MaterialTheme.shapes.medium,
        color = MaterialTheme.colorScheme.surface,
        border =
          BorderStroke(
            1.dp,
            if (expanded) MaterialTheme.colorScheme.secondary.copy(alpha = 0.55f)
            else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f),
          ),
        modifier =
          Modifier.fillMaxWidth()
            .minimumInteractiveComponentSize()
            .clickable { expanded = !expanded }
            .testTag("imp_question_${lessonId}_$index"),
      ) {
        Column(
          modifier = Modifier.fillMaxWidth().padding(14.dp),
          verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
          Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top,
          ) {
            Text(
              text = "Q${index + 1}. ${qa.question}",
              style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold),
              color = MaterialTheme.colorScheme.onSurface,
              modifier = Modifier.weight(1f).padding(end = 8.dp),
            )
            Icon(
              imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
              contentDescription = if (expanded) strings.hideAnswer else strings.tapToShowAnswer,
              tint = MaterialTheme.colorScheme.secondary,
            )
          }

          Text(
            text = if (expanded) strings.hideAnswer else strings.tapToShowAnswer,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.secondary,
          )

          AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically(),
          ) {
            Surface(
              shape = RoundedCornerShape(10.dp),
              color = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.65f),
              modifier = Modifier.fillMaxWidth(),
            ) {
              Text(
                text = qa.answer,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                modifier = Modifier.padding(12.dp),
              )
            }
          }
        }
      }
    }
  }
}
