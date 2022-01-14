@file:Suppress("DEPRECATION", "NOTHING_TO_INLINE", "unused", "UNUSED_PARAMETER")

package coil.compose

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.AsyncImagePainter.State
import coil.imageLoader
import coil.request.ImageRequest

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

@Deprecated(
    message = "ImagePainter has been renamed to AsyncImagePainter.",
    replaceWith = ReplaceWith(
        expression = "rememberAsyncImagePainter(data)",
        imports = ["coil.compose.rememberAsyncImagePainter"]
    )
)
@Composable
inline fun rememberImagePainter(
    data: Any?,
) = rememberAsyncImagePainter(data)

@Deprecated(
    message = "ImagePainter has been renamed to AsyncImagePainter.",
    replaceWith = ReplaceWith(
        expression = "rememberAsyncImagePainter(data)",
        imports = ["coil.compose.rememberAsyncImagePainter"]
    ),
    level = DeprecationLevel.ERROR // ExecuteCallback is no longer supported.
)
@Composable
inline fun rememberImagePainter(
    data: Any?,
    onExecute: ExecuteCallback,
) = rememberAsyncImagePainter(data)

@Deprecated(
    message = "ImagePainter has been renamed to AsyncImagePainter.",
    replaceWith = ReplaceWith(
        expression = "rememberAsyncImagePainter(" +
            "ImageRequest.Builder(LocalContext.current).data(data).apply(builder).build())",
        imports = [
            "androidx.compose.ui.platform.LocalContext",
            "coil.compose.rememberAsyncImagePainter",
            "coil.request.ImageRequest",
        ]
    )
)
@Composable
inline fun rememberImagePainter(
    data: Any?,
    builder: ImageRequest.Builder.() -> Unit,
) = rememberAsyncImagePainter(
    model = ImageRequest.Builder(LocalContext.current).data(data).apply(builder).build()
)

@Deprecated(
    message = "ImagePainter has been renamed to AsyncImagePainter.",
    replaceWith = ReplaceWith(
        expression = "rememberAsyncImagePainter(" +
            "ImageRequest.Builder(LocalContext.current).data(data).apply(builder).build())",
        imports = [
            "androidx.compose.ui.platform.LocalContext",
            "coil.compose.rememberAsyncImagePainter",
            "coil.request.ImageRequest",
        ]
    ),
    level = DeprecationLevel.ERROR // ExecuteCallback is no longer supported.
)
@Composable
inline fun rememberImagePainter(
    data: Any?,
    onExecute: ExecuteCallback,
    builder: ImageRequest.Builder.() -> Unit,
) = rememberAsyncImagePainter(
    model = ImageRequest.Builder(LocalContext.current).data(data).apply(builder).build()
)

@Deprecated(
    message = "ImagePainter has been renamed to AsyncImagePainter.",
    replaceWith = ReplaceWith(
        expression = "rememberAsyncImagePainter(request)",
        imports = ["coil.compose.rememberAsyncImagePainter"]
    )
)
@Composable
inline fun rememberImagePainter(
    request: ImageRequest,
) = rememberAsyncImagePainter(request)

@Deprecated(
    message = "ImagePainter has been renamed to AsyncImagePainter.",
    replaceWith = ReplaceWith(
        expression = "rememberAsyncImagePainter(request)",
        imports = ["coil.compose.rememberAsyncImagePainter"]
    ),
    level = DeprecationLevel.ERROR // ExecuteCallback is no longer supported.
)
@Composable
inline fun rememberImagePainter(
    request: ImageRequest,
    onExecute: ExecuteCallback,
) = rememberAsyncImagePainter(request)

private typealias ExecuteCallback = (Snapshot, Snapshot) -> Boolean

private typealias Snapshot = Triple<State, ImageRequest, Size>
