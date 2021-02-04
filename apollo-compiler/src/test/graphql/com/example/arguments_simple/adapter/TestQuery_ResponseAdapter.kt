// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.arguments_simple.adapter

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import com.example.arguments_simple.TestQuery
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField(
      type = ResponseField.Type.Named.Object("Character"),
      responseName = "hero",
      fieldName = "hero",
      arguments = mapOf<String, Any?>(
        "episode" to mapOf<String, Any?>(
          "kind" to "Variable",
          "variableName" to "episode"),
        "listOfListOfStringArgs" to mapOf<String, Any?>(
          "kind" to "Variable",
          "variableName" to "listOfListOfStringArgs")),
      conditions = emptyList(),
    ),
    ResponseField(
      type = ResponseField.Type.Named.Object("Human"),
      responseName = "heroWithReview",
      fieldName = "heroWithReview",
      arguments = mapOf<String, Any?>(
        "episode" to mapOf<String, Any?>(
          "kind" to "Variable",
          "variableName" to "episode"),
        "review" to mapOf<String, Any?>(
          "stars" to 5,
          "favoriteColor" to mapOf<String, Any?>(
            "red" to 1,
            "blue" to 1.0),
          "listOfStringNonOptional" to emptyList<Any?>())),
      conditions = emptyList(),
    )
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return reader.run {
      var hero: TestQuery.Data.Hero? = null
      var heroWithReview: TestQuery.Data.HeroWithReview? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> hero = readObject<TestQuery.Data.Hero>(RESPONSE_FIELDS[0]) { reader ->
            Hero.fromResponse(reader)
          }
          1 -> heroWithReview = readObject<TestQuery.Data.HeroWithReview>(RESPONSE_FIELDS[1]) { reader ->
            HeroWithReview.fromResponse(reader)
          }
          else -> break
        }
      }
      TestQuery.Data(
        hero = hero,
        heroWithReview = heroWithReview
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    if(value.hero == null) {
      writer.writeObject(RESPONSE_FIELDS[0], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
        Hero.toResponse(writer, value.hero)
      }
    }
    if(value.heroWithReview == null) {
      writer.writeObject(RESPONSE_FIELDS[1], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[1]) { writer ->
        HeroWithReview.toResponse(writer, value.heroWithReview)
      }
    }
  }

  object Hero : ResponseAdapter<TestQuery.Data.Hero> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
        responseName = "__typename",
        fieldName = "__typename",
        arguments = emptyMap(),
        conditions = emptyList(),
      ),
      ResponseField(
        type = ResponseField.Type.Named.Other("String"),
        responseName = "name",
        fieldName = "name",
        arguments = emptyMap(),
        conditions = listOf(
          ResponseField.Condition.booleanCondition("IncludeName", false)
        ),
      )
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data.Hero {
      val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
      return when(typename) {
        "Droid" -> CharacterHero.fromResponse(reader, typename)
        "Human" -> CharacterHero.fromResponse(reader, typename)
        else -> OtherHero.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero) {
      when(value) {
        is TestQuery.Data.Hero.CharacterHero -> CharacterHero.toResponse(writer, value)
        is TestQuery.Data.Hero.OtherHero -> OtherHero.toResponse(writer, value)
      }
    }

    object CharacterHero : ResponseAdapter<TestQuery.Data.Hero.CharacterHero> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.Named.Other("String"),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = listOf(
            ResponseField.Condition.booleanCondition("IncludeName", false)
          ),
        ),
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Object("FriendsConnection")),
          responseName = "friendsConnection",
          fieldName = "friendsConnection",
          arguments = mapOf<String, Any?>(
            "first" to mapOf<String, Any?>(
              "kind" to "Variable",
              "variableName" to "friendsCount")),
          conditions = emptyList(),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.CharacterHero {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          var friendsConnection: TestQuery.Data.Hero.CharacterHero.FriendsConnection? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              2 -> friendsConnection = readObject<TestQuery.Data.Hero.CharacterHero.FriendsConnection>(RESPONSE_FIELDS[2]) { reader ->
                FriendsConnection.fromResponse(reader)
              }
              else -> break
            }
          }
          TestQuery.Data.Hero.CharacterHero(
            __typename = __typename!!,
            name = name,
            friendsConnection = friendsConnection!!
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.CharacterHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
        writer.writeObject(RESPONSE_FIELDS[2]) { writer ->
          FriendsConnection.toResponse(writer, value.friendsConnection)
        }
      }

      object FriendsConnection :
          ResponseAdapter<TestQuery.Data.Hero.CharacterHero.FriendsConnection> {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField(
            type = ResponseField.Type.Named.Other("Int"),
            responseName = "totalCount",
            fieldName = "totalCount",
            arguments = emptyMap(),
            conditions = emptyList(),
          ),
          ResponseField(
            type = ResponseField.Type.List(ResponseField.Type.Named.Object("FriendsEdge")),
            responseName = "edges",
            fieldName = "edges",
            arguments = emptyMap(),
            conditions = emptyList(),
          )
        )

        override fun fromResponse(reader: ResponseReader, __typename: String?):
            TestQuery.Data.Hero.CharacterHero.FriendsConnection {
          return reader.run {
            var totalCount: Int? = null
            var edges: List<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge?>? = null
            while(true) {
              when (selectField(RESPONSE_FIELDS)) {
                0 -> totalCount = readInt(RESPONSE_FIELDS[0])
                1 -> edges = readList<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge>(RESPONSE_FIELDS[1]) { reader ->
                  reader.readObject<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge> { reader ->
                    Edge.fromResponse(reader)
                  }
                }
                else -> break
              }
            }
            TestQuery.Data.Hero.CharacterHero.FriendsConnection(
              totalCount = totalCount,
              edges = edges
            )
          }
        }

        override fun toResponse(writer: ResponseWriter,
            value: TestQuery.Data.Hero.CharacterHero.FriendsConnection) {
          writer.writeInt(RESPONSE_FIELDS[0], value.totalCount)
          writer.writeList(RESPONSE_FIELDS[1], value.edges) { value, listItemWriter ->
            listItemWriter.writeObject { writer ->
              Edge.toResponse(writer, value)
            }
          }
        }

        object Edge : ResponseAdapter<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge> {
          private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField(
              type = ResponseField.Type.Named.Object("Character"),
              responseName = "node",
              fieldName = "node",
              arguments = emptyMap(),
              conditions = emptyList(),
            )
          )

          override fun fromResponse(reader: ResponseReader, __typename: String?):
              TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge {
            return reader.run {
              var node: TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node? = null
              while(true) {
                when (selectField(RESPONSE_FIELDS)) {
                  0 -> node = readObject<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node>(RESPONSE_FIELDS[0]) { reader ->
                    Node.fromResponse(reader)
                  }
                  else -> break
                }
              }
              TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge(
                node = node
              )
            }
          }

          override fun toResponse(writer: ResponseWriter,
              value: TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge) {
            if(value.node == null) {
              writer.writeObject(RESPONSE_FIELDS[0], null)
            } else {
              writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
                Node.toResponse(writer, value.node)
              }
            }
          }

          object Node :
              ResponseAdapter<TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node> {
            private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
              ResponseField(
                type = ResponseField.Type.Named.Other("String"),
                responseName = "name",
                fieldName = "name",
                arguments = emptyMap(),
                conditions = listOf(
                  ResponseField.Condition.booleanCondition("IncludeName", false)
                ),
              )
            )

            override fun fromResponse(reader: ResponseReader, __typename: String?):
                TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node {
              return reader.run {
                var name: String? = null
                while(true) {
                  when (selectField(RESPONSE_FIELDS)) {
                    0 -> name = readString(RESPONSE_FIELDS[0])
                    else -> break
                  }
                }
                TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node(
                  name = name
                )
              }
            }

            override fun toResponse(writer: ResponseWriter,
                value: TestQuery.Data.Hero.CharacterHero.FriendsConnection.Edge.Node) {
              writer.writeString(RESPONSE_FIELDS[0], value.name)
            }
          }
        }
      }
    }

    object OtherHero : ResponseAdapter<TestQuery.Data.Hero.OtherHero> {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
        ResponseField(
          type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
          responseName = "__typename",
          fieldName = "__typename",
          arguments = emptyMap(),
          conditions = emptyList(),
        ),
        ResponseField(
          type = ResponseField.Type.Named.Other("String"),
          responseName = "name",
          fieldName = "name",
          arguments = emptyMap(),
          conditions = listOf(
            ResponseField.Condition.booleanCondition("IncludeName", false)
          ),
        )
      )

      override fun fromResponse(reader: ResponseReader, __typename: String?):
          TestQuery.Data.Hero.OtherHero {
        return reader.run {
          var __typename: String? = __typename
          var name: String? = null
          while(true) {
            when (selectField(RESPONSE_FIELDS)) {
              0 -> __typename = readString(RESPONSE_FIELDS[0])
              1 -> name = readString(RESPONSE_FIELDS[1])
              else -> break
            }
          }
          TestQuery.Data.Hero.OtherHero(
            __typename = __typename!!,
            name = name
          )
        }
      }

      override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.Hero.OtherHero) {
        writer.writeString(RESPONSE_FIELDS[0], value.__typename)
        writer.writeString(RESPONSE_FIELDS[1], value.name)
      }
    }
  }

  object HeroWithReview : ResponseAdapter<TestQuery.Data.HeroWithReview> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField(
        type = ResponseField.Type.NotNull(ResponseField.Type.Named.Other("String")),
        responseName = "name",
        fieldName = "name",
        arguments = emptyMap(),
        conditions = emptyList(),
      )
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        TestQuery.Data.HeroWithReview {
      return reader.run {
        var name: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> name = readString(RESPONSE_FIELDS[0])
            else -> break
          }
        }
        TestQuery.Data.HeroWithReview(
          name = name!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Data.HeroWithReview) {
      writer.writeString(RESPONSE_FIELDS[0], value.name)
    }
  }
}