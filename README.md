# Pattern_MVC
//16.07.22

Занятие 42. Тема: Архитектурный Паттер MVC(модель, представление, контроллер)

**Тема: Паттерны проектирования
Архитектурный паттерн проектирования - MVC

Пример:
//Статическая страница на HTML не умеет реагировать на действия пользователя.
//Для двухстороннего взаимодействия нужны динамические веб-страницы.
//MVC — ключ к пониманию разработки динамических веб-приложений, поэтому разработчику нужно знать эту модель

//Model-View-Controller — схема разделения данных приложения и управляющей логики на три отдельных компонента:
//модель, представление и контроллер — таким образом,
//что модификация каждого компонента может осуществляться независимо.
//Модель предоставляет данные и реагирует на команды контроллера, изменяя своё состояние.

//Это способ организации кода, который предполагает выделение блоков, отвечающих за решение разных задач.
//Один блок отвечает за данные приложения, другой отвечает за внешний вид,
//а третий контролирует работу приложения.
// Компоненты MVC:
//Модель — этот компонент отвечает за данные, а также определяет структуру приложения.
//Например, если вы создаете To-Do приложение,
//код компонента model будет определять список задач и отдельные задачи.
//Представление — этот компонент отвечает за взаимодействие с пользователем.
//То есть код компонента view определяет внешний вид приложения и способы его использования.
//Контроллер — этот компонент отвечает за связь между model и view.
//Код компонента controller определяет, как сайт реагирует на действия пользователя. По сути, это мозг MVC-приложения.
