package com.example.data.local

object SeedContent {
  val diagrams: List<CircuitDiagramEntity> = SeedDiagrams.diagrams
  val components: List<CircuitComponentEntity> = SeedDiagrams.components
  val lessons: List<LessonEntity> = SeedStd9And10.lessons + SeedStd11And12.lessons
  val practicals: List<PracticalEntity> = SeedStd9And10.practicals + SeedStd11And12.practicals
  val practicalSteps: List<PracticalStepEntity> =
    SeedStd9And10.practicalSteps + SeedStd11And12.practicalSteps
}
