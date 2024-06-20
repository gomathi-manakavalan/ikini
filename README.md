This is a chatgpt Translator. 
Translates any language messages into English.


![WhatsApp Image 2024-06-19 at 11 44 43 PM](https://github.com/gomathi-manakavalan/ikini/assets/62669989/faa9548e-3e0b-4ee8-8957-456e441a948b)
![WhatsApp Image 2024-06-19 at 11 44 43 PM](https://github.com/gomathi-manakavalan/ikini/assets/62669989/faa9548e-3e0b-4ee8-8957-456e441a948b)

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

<img width="614" alt="Demo" src="https://github.com/gomathi-manakavalan/ikini/assets/62669989/8c519fec-a356-47b9-a904-9bee54a19365">
