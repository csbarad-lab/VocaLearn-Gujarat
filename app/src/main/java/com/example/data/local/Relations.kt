package com.example.data.local

import androidx.room.Embedded
import androidx.room.Relation

data class PracticalWithSteps(
  @Embedded val practical: PracticalEntity,
  @Relation(parentColumn = "practical_id", entityColumn = "practical_id")
  val steps: List<PracticalStepEntity>,
) {
  val orderedSteps: List<PracticalStepEntity>
    get() = steps.sortedBy { it.stepNumber }
}

data class CircuitDiagramWithComponents(
  @Embedded val diagram: CircuitDiagramEntity,
  @Relation(parentColumn = "diagram_id", entityColumn = "diagram_id")
  val components: List<CircuitComponentEntity>,
) {
  val orderedComponents: List<CircuitComponentEntity>
    get() = components.sortedBy { it.sortOrder }
}
