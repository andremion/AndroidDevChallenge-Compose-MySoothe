# Put title of your app here

![Workflow result](https://github.com/andremion/AndroidDevChallenge-Compose-MySoothe/workflows/Check/badge.svg)


## :scroll: Description
Implementation of [design specs](specs) provided for the propose of [Android Dev Challenge Week #3](https://android-developers.googleblog.com/2021/03/android-dev-challenge-3.html)

#### Português-🇧🇷

Implementação das [especificações de design](specs) fornecida para o [Android Dev Challenge Week #3](https://android-developers.googleblog.com/2021/03/android-dev-challenge-3.html)


## :bulb: Motivation and Context
I liked how the [especificações de design](specs) were done.
They have some different approaches, e.g.: screen background provided by a mix of *svg* and color from the theme. It was the first time I ever used *svg* for backgrounds.

Fun fact: I spent half an hour working on the title of the welcome screen, trying to do that regular/bold style in a single *string*.
I managed to do that with [SpanStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/SpanStyle), but the result was not yet as expected.
Even though using `MaterialTheme.typography.h1`, the font face looked different...
Actually, it was not supposed to use *string* because it was provided *svg* files for that logo 🤦🏻‍♂️    

It was annoying when I started to use [Navigation classes](https://developer.android.com/jetpack/compose/navigation) and the [Preview](https://developer.android.com/jetpack/compose/tooling#preview) stopped working. I think that still needs to be improved by *Jetpack Compose* team.

Another thing I've noticed was setting a text style smaller than the default of a custom height `TextField`, makes the placeholder and labels be not vertically centralized. I needed to do a small [work around](https://github.com/andremion/AndroidDevChallenge-Compose-MySoothe/blob/main/app/src/main/java/com/example/androiddevchallenge/ui/component/Texts.kt#L45) to minimize that. 

#### Português-🇧🇷

Eu gostei como as [especificações de design](specs) foram feitas.
Elas tem umas abordagens diferentes. Por exemplo, o fundo de tela feito através de uma mistura de *svg* com uma cor do tema. Foi a primeira vez que eu usei *svg* para plano de fundo.

Curiosidade: Eu passei meia hora trabalhando no título da tela de Welcome, tentando fazer aquele estilo regular/negrito usando uma mesma *string*.
Eu consegui usando [SpanStyle](https://developer.android.com/reference/kotlin/androidx/compose/ui/text/SpanStyle?hl=pt-br), mas o resultado ainda não era o esperado.
Mesmo usando `MaterialTheme.typography.h1`, a fonte parecia diferente...
Na verdade, não era pra usar *string* porque foi fornecido arquivos *svg* para o logo 🤦🏻‍♂️

Foi chato quando eu comecei a usar [Navigation classes](https://developer.android.com/jetpack/compose/navigation?hl=pt-br) e o [Preview](https://developer.android.com/jetpack/compose/tooling#preview?hl=pt-br) parou de funcionar. Acho que o time do *Jetpack Compose* ainda precisa melhorar aquilo.

Outra coisa que eu notei foi configurar um estilo de texto menor que o padrão do `TextField` com uma altura personalizada, faz o *placeholder* e o *label* ficarem descentralizado verticalmente. I precisei fazer um [artifício tecnológico não autorizado](https://github.com/andremion/AndroidDevChallenge-Compose-MySoothe/blob/main/app/src/main/java/com/example/androiddevchallenge/ui/component/Texts.kt#L45) para corrigir.

## :camera_flash: Screenshots
<img src="/results/screenshot_1.png" width="260">&emsp;<img src="/results/screenshot_2.png" width="260">&emsp;<img src="/results/screenshot_3.png" width="260">

## License
```
Copyright 2020 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
