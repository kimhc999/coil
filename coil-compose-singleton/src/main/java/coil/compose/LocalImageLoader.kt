@file:Suppress("DEPRECATION", "unused")

package coil.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.imageLoader

private const val DEPRECATION_MESSAGE = ""

/**
 * A pseudo-[CompositionLocal] that returns the current [ImageLoader] for the composition.
 * If a local [ImageLoader] has not been provided, it returns the singleton [ImageLoader].
 */
@Deprecated(message = DEPRECATION_MESSAGE)
val LocalImageLoader = ImageLoaderProvidableCompositionLocal()

@Deprecated(message = DEPRECATION_MESSAGE)
@JvmInline
value class ImageLoaderProvidableCompositionLocal internal constructor(
    private val delegate: ProvidableCompositionLocal<ImageLoader?> = staticCompositionLocalOf { null }
) {

    @Deprecated(
        message = DEPRECATION_MESSAGE,
        replaceWith = ReplaceWith(
            expression = "LocalContext.current.imageLoader",
            imports = ["androidx.compose.ui.platform.LocalContext", "coil.imageLoader"]
        )
    )
    val current: ImageLoader
        @Composable
        @ReadOnlyComposable
        get() = delegate.current ?: LocalContext.current.imageLoader

    @Deprecated(
        message = DEPRECATION_MESSAGE,
        replaceWith = ReplaceWith(
            expression = "Coil.setImageLoader(value)",
            imports = ["coil.Coil"]
        )
    )
    infix fun provides(value: ImageLoader) = delegate provides value
}
