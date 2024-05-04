package io.github.boguszpawlowski.composecalendar.states

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue

@Suppress("FunctionName") // Factory function
public fun ModeState(initialMode: Int): ModeState = ModeStateImpl(initialMode)

@Stable
public interface ModeState {
  public var mode: Int

  public companion object {
    @Suppress("FunctionName") // Factory function
    public fun Saver(): Saver<ModeState, String> = Saver(
      save = { it.mode.toString() },
      restore = { ModeState(it.toInt()) }
    )

    public const val MODE_WEEK: Int = 0
    public const val MODE_MONTH: Int = 1
    public const val MODE_OFF: Int = 2
  }
}

@Stable
private class ModeStateImpl(
  initialMode: Int,
) : ModeState {

  private var _currentMode by mutableStateOf<Int>(initialMode)

  override var mode: Int
    get() = _currentMode
    set(value) {
      _currentMode = value
    }
}