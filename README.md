This is a chatgpt Translator. 
Translates any language messages into English.

Request

curl --location 'http://localhost:8080/api/chatgpt/ask' \
--header 'Content-Type: application/json' \
--form 'prompt="கற்றலின், கேட்டலே நன்று"'

Response
```
{
  "id": "chatcmpl-9c1GPpJVHVP2y8vFONftwXCZaqFlP",
  "object": "chat.completion",
  "created": 1718848349,
  "model": "gpt-3.5-turbo-0125",
  "choices": [
    {
      "index": 0,
      "message": {
        "role": "assistant",
        "content": "In learning, listening is better than hearing."
      },
      "logprobs": null,
      "finish_reason": "stop"
    }
  ],
  "usage": {
    "prompt_tokens": 61,
    "completion_tokens": 9,
    "total_tokens": 70
  },
  "system_fingerprint": null
}

```